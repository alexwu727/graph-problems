package io.github.alexwu727.utils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GraphTest {

    @Test
    public void addEdge() {
        Graph graph = new Graph();
        graph.addEdge(0, 1, 10);
        graph.addEdge(1, 2, 5);

        assertEquals(2, graph.edges.size());
        assertEquals(0, graph.edges.get(0).src);
        assertEquals(1, graph.edges.get(0).dest);
        assertEquals(10, graph.edges.get(0).weight);
    }
}