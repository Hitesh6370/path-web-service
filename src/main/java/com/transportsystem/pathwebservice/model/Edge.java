package com.transportsystem.pathwebservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * The type Edge.
 */
@Data
@AllArgsConstructor
public class Edge {
    private final int id;
    private final Vertex source;
    private final Vertex destination;
    private final double weight;
}
