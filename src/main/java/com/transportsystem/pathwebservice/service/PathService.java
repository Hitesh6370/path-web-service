package com.transportsystem.pathwebservice.service;

import com.transportsystem.pathwebservice.model.RouteDetails;
import com.transportsystem.pathwebservice.model.*;
import com.transportsystem.pathwebservice.restclient.DBRestClient;
import com.transportsystem.pathwebservice.util.PathCalculator;
import com.transportsystem.soap.PathDetails;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

@Service
public class PathService {

    DBRestClient client = new DBRestClient();

    public List<RouteDetails> routeDetails() {
        System.out.println("inside the service");
        return client.getRouteDetails();
    }

    public PathDetails shortestPath(String s, String d) {
        LinkedList<Vertex> path = new LinkedList<Vertex>();
        List<Vertex> vertices = new ArrayList<>();
        List<Planet> planets = client.getPlanetList();
        for (Planet p : planets) {
            Vertex v = new Vertex(p.getPlanet_node(), p.getPlanet_name());
            vertices.add(v);
        }

        List<Edge> edges = new ArrayList<>();
        List<RouteDetails> routes = client.getRouteDetails();
        for (RouteDetails r : routes) {
            Vertex source = null;
            Vertex destination = null;
            for (Vertex v : vertices) {
                if (v.getId().equals(r.getPlanet_origin_id())) {
                    source = v;
                }
                if (v.getId().equals(r.getPlanet_destination_id())) {
                    destination = v;
                }
            }
            Edge e = new Edge(r.getRoute_id(), source, destination, r.getDistance());
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
        ListIterator list_Iter = path.listIterator(0);

        List<RouteDetails> routeDetails = routeDetails();
        String prv = null;
        String nxt = null;
        double distance = 0.0;
        double traffic = 0.0;
        while (list_Iter.hasNext()) {

            if (prv == null) {
                prv = list_Iter.next().toString();
                continue;
            }
            nxt = list_Iter.next().toString();
            if (prv != null && nxt != null) {
                for (RouteDetails route : routeDetails) {
                    if (route.getPlanet_origin_name().equals(prv) && route.getPlanet_destination_name().equals(nxt)) {
                        distance = distance + route.getDistance();
                        traffic = traffic + route.getTraffic_delay();
                        break;
                    }
                }
                prv = nxt;
            }
        }
        pathDetails.setDistance(distance);
        pathDetails.setDuration(traffic);
        return pathDetails;
    }
}
