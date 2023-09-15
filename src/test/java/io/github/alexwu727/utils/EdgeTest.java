package io.github.alexwu727.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EdgeTest {
    @Test
    public void testEdgeFields() {
        Edge edge = new Edge(0, 1, 10);

        assertEquals(0, edge.src);
        assertEquals(1, edge.dest);
        assertEquals(10, edge.weight);
    }

    @Test
    void compareTo() {
        Edge edge1 = new Edge(0, 1, 10);
        Edge edge2 = new Edge(0, 2, 6);

        assertEquals(4, edge1.compareTo(edge2));
    }
}