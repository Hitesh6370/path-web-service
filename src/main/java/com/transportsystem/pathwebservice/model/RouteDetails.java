package com.transportsystem.pathwebservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The type Route details.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RouteDetails {

    private int routeId;
    private String planetOriginNode;
    private String planetOriginName;
    private String planetDestinationNode;
    private String planetDestinationName;
    private double distance;
    private double trafficDelay;
}
