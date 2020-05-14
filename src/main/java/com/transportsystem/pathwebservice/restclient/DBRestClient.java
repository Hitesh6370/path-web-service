package com.transportsystem.pathwebservice.restclient;

import com.transportsystem.pathwebservice.model.Planet;
import com.transportsystem.pathwebservice.model.RouteDetails;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * The type Db rest client.
 */
public class DBRestClient {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String baseUrl = "https://app-gateway.herokuapp.com/api";

    /**
     * Gets route details.
     *
     * @return the route details
     */
    public List<RouteDetails> getRouteDetails() {
        // RouteDetails[]dbResponse=restTemplate.getForObject(baseUrl+"/details",RouteDetails[].class);
         ResponseEntity<List<RouteDetails>> response = restTemplate.exchange(baseUrl + "/details", HttpMethod.GET,null,new ParameterizedTypeReference<List<RouteDetails>>() {
        });
        return response.getBody();
    }

    /**
     * Gets planet list.
     *
     * @return the planet list
     */
    public List<Planet> getPlanetList() {
        ResponseEntity<List<Planet>> response = restTemplate.exchange(baseUrl + "/planets", HttpMethod.GET,null,new ParameterizedTypeReference<List<Planet>>(){});
        return response.getBody();
    }
}
