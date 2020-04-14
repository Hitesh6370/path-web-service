package com.transportsystem.pathwebservice.model;

import lombok.Data;

import java.util.List;

@Data
public class Graph {

    private final List<Vertex> vertexes;
    private final List<Edge> edges;

    public Graph(List<Vertex> vertexes, List<Edge> edges) {
        this.vertexes = vertexes;
        this.edges = edges;
    }
}
