package io.github.alexwu727.utils;

public class Edge implements Comparable<Edge> {
    public int src, dest, weight;

    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge otherEdge) {
        return this.weight - otherEdge.weight;
    }
}
