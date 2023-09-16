package io.github.alexwu727.utils;

public class Node {
    private final int id;
    private boolean visited;

    public Node(int id) {
        this.id = id;
        this.visited = false;
    }

    public int getId() {
        return id;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", visited=" + visited +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Node) {
            Node otherNode = (Node) obj;
            return this.id == otherNode.id && this.visited == otherNode.visited;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.id;
    }
}
