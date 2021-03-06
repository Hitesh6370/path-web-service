package com.transportsystem.pathwebservice.web.soap;

import com.transportsystem.pathwebservice.service.PathService;
import com.transportsystem.soap.GetPathDetailsRequest;
import com.transportsystem.soap.GetPathDetailsResponse;
import com.transportsystem.soap.PathDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * The type Path details end point.
 */
@Endpoint
public class PathDetailsEndPoint {


    /**
     * The Service.
     */
    @Autowired
    PathService service;

    /**
     * Process course details request get path details response.
     *
     * @param request the request
     * @return the get path details response
     */
    @PayloadRoot(namespace = "http://transportsystem.com/soap", localPart = "GetPathDetailsRequest")
    @ResponsePayload
    public GetPathDetailsResponse processCourseDetailsRequest(@RequestPayload GetPathDetailsRequest request) {
        GetPathDetailsResponse response = new GetPathDetailsResponse();
        PathDetails pathDetails = service.shortestPath(request.getSource(),request.getDestination());
        response.setPathDetails(pathDetails);
        return response;
    }
}