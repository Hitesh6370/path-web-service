package com.transportsystem.pathwebservice.web.rest;

import com.transportsystem.pathwebservice.service.PathService;
import com.transportsystem.soap.GetPathDetailsRequest;
import com.transportsystem.soap.PathDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * The type Path details controller.
 */
@RequestMapping(value = "/api",
        produces = {
                APPLICATION_JSON_VALUE,
        })
@RestController
class PathDetailsController {


    /**
     * The Path service.
     */
    private PathService pathService;

    /**
     * Instantiates a new Path details controller.
     *
     * @param pathService the path service
     */
    @Autowired
    public PathDetailsController(final PathService pathService)
    {
        this.pathService = pathService;
    }


    /**
     * Gets path details.
     *
     * @param pathRequest the path request
     * @return the path details
     */
    @RequestMapping(value = "/path", method = POST, produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public PathDetails getPathDetails(@RequestBody GetPathDetailsRequest pathRequest)
    {
        return pathService.shortestPath(pathRequest.getSource(),pathRequest.getDestination());
    }
}
