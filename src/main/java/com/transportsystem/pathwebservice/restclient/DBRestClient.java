package com.transportsystem.pathwebservice.restclient;

import com.transportsystem.pathwebservice.model.Planet;
import com.transportsystem.pathwebservice.model.RouteDetails;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class DBRestClient {

    RestTemplate restTemplate= new RestTemplate();
    String baseUrl = "http://localhost:8086/api";

    public List<RouteDetails> getRouteDetails()
    {
        // RouteDetails[]dbResponse=restTemplate.getForObject(baseUrl+"/details",RouteDetails[].class);
        ResponseEntity<List<RouteDetails>> response = restTemplate.exchange(baseUrl+"/details", HttpMethod.GET,null,new ParameterizedTypeReference<List<RouteDetails>>() {
        });
        List<RouteDetails> routeDetails = response.getBody();
       return routeDetails;
    }

    public List<Planet> getPlanetList()
    {
        ResponseEntity<List<Planet>> response = restTemplate.exchange(baseUrl+"/planets", HttpMethod.GET,null,new ParameterizedTypeReference<List<Planet>>() {
        });
        List<Planet> planets = response.getBody();
        return planets;
    }
}
