package com.transportsystem.pathwebservice.model;

import lombok.Data;

import java.util.List;

/**
 * The type Graph.
 */
@Data
public class Graph {

    private final List<Vertex> vertexes;
    private final List<Edge> edges;

    /**
     * Instantiates a new Graph.
     *
     * @param vertexes the vertexes
     * @param edges    the edges
     */
    public Graph(List<Vertex> vertexes, List<Edge> edges) {
        this.vertexes = vertexes;
        this.edges = edges;
    }
}
