package io.github.alexwu727.utils;

import java.util.ArrayList;

public class Graph {
    public ArrayList<Edge> edges;

    public Graph() {
        this.edges = new ArrayList<>();
    }

    public void addEdge(int src, int dest, int weight) {
        Edge newEdge = new Edge(src, dest, weight);
        edges.add(newEdge);
    }
}