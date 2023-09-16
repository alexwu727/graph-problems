package io.github.alexwu727.utils;

public class Edge implements Comparable<Edge> {
    private final int src;
    private final int dest;
    private int weight;

    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    public int getSrc() {
        return src;
    }

    public int getDest() {
        return dest;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge otherEdge) {
        return this.weight - otherEdge.weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "src=" + src +
                ", dest=" + dest +
                ", weight=" + weight +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Edge) {
            Edge otherEdge = (Edge) obj;
            return this.src == otherEdge.src && this.dest == otherEdge.dest && this.weight == otherEdge.weight;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.src + this.dest + this.weight;
    }
}
