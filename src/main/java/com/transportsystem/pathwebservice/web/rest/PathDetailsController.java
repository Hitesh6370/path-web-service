package com.transportsystem.pathwebservice.web.rest;

import com.transportsystem.pathwebservice.model.PathRequest;
import com.transportsystem.pathwebservice.service.PathService;
import com.transportsystem.soap.GetPathDetailsRequest;
import com.transportsystem.soap.PathDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RequestMapping(value = "/api",
        produces = {
                APPLICATION_JSON_VALUE,
        })
@RestController
public class PathDetailsController {

    private PathService pathService;

    @Autowired
    public PathDetailsController(final PathService pathService)
    {
        this.pathService = pathService;
    }


    @RequestMapping(value = "/path", method = POST, produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public PathDetails getPathDetails(@RequestBody GetPathDetailsRequest pathRequest)
    {
        PathDetails response = pathService.shortestPath(pathRequest.getSource(),pathRequest.getDestination());
        return response;
    }
}
