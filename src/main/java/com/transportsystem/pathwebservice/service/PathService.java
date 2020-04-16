package com.transportsystem.pathwebservice.service;

import com.transportsystem.pathwebservice.model.*;
import com.transportsystem.pathwebservice.restclient.DBRestClient;
import com.transportsystem.pathwebservice.util.PathCalculator;
import com.transportsystem.soap.PathDetails;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * The type Path service.
 */
@Service
public class PathService {
    private final DBRestClient client = new DBRestClient();

    private List<RouteDetails> routeDetails() {
        System.out.println("inside the service");
        return client.getRouteDetails();
    }

    /**
     * Shortest path path details.
     *
     * @param s the s
     * @param d the d
     * @return the path details
     */
    public PathDetails shortestPath(final String s, final String d) {
        LinkedList<Vertex> path = new LinkedList<>();
        List<Vertex> vertices = new ArrayList<>();
        List<Planet> planets = client.getPlanetList();
        for (Planet p : planets) {
            Vertex v = new Vertex(p.getPlanetNode(), p.getPlanetName());
            vertices.add(v);
        }

        List<Edge> edges = new ArrayList<>();
        List<RouteDetails> routes = client.getRouteDetails();
        for (RouteDetails r : routes) {
            Vertex source = null;
            Vertex destination = null;
            for (Vertex v : vertices) {
                if (v.getId().equals(r.getPlanetOriginNode())) {
                    source = v;
                }
                if (v.getId().equals(r.getPlanetDestinationNode())) {
                    destination = v;
                }
            }
            Edge e = new Edge(r.getRouteId(), source, destination, r.getDistance());
            edges.add(e);
        }
        Graph graph = new Graph(vertices, edges);
        PathCalculator calculator = new PathCalculator(graph);
        for (Vertex v : vertices) {
            if (v.getName().equals(s)) {
                calculator.execute(v);
                break;
            }
        }
        for (Vertex v : vertices) {
            if (v.getName().equals(d)) {
                path = calculator.getPath(v);
                break;
            }
        }
        PathDetails pathDetails = new PathDetails();
        pathDetails.setSource(s);
        pathDetails.setDestination(d);
        pathDetails.setPath(path.toString());
        ListIterator listIterator = path.listIterator(0);

        List<RouteDetails> routeDetails = routeDetails();
        String prv = null;
        String nxt = null;
        double duration = 0.0;
        double traffic = 0.0;
        while (listIterator.hasNext()) {
            if (prv == null) {
                prv = listIterator.next().toString();
            }
            else {
                nxt = listIterator.next().toString();
                for (RouteDetails route : routeDetails) {
                    if (route.getPlanetOriginName().equals(prv) && route.getPlanetDestinationName().equals(nxt)) {
                        duration = duration + route.getDistance();
                        traffic = traffic + route.getTrafficDelay();
                        break;
                    }
                }
                prv = nxt;
            }
        }
        pathDetails.setDuration(duration);
        pathDetails.setDelay(traffic);
        return pathDetails;
    }
}
