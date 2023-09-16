package io.github.alexwu727.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EdgeTest {

    private Edge edge;
    @BeforeEach
    void setUp() {
        edge = new Edge(0, 1, 10);
    }

    @Test
    void testEdgeConstructor() {
        Edge edge = new Edge(0, 1, 10);
        assertEquals(0, edge.getSrc());
        assertEquals(1, edge.getDest());
        assertEquals(10, edge.getWeight());
    }

    @Test
    void testGetSrc() {
        assertEquals(0, edge.getSrc());
    }

    @Test
    void testGetDest() {
        assertEquals(1, edge.getDest());
    }

    @Test
    void testGetWeight() {
        assertEquals(10, edge.getWeight());
    }

    @Test
    void testSetWeight() {
        edge.setWeight(20);
        assertEquals(20, edge.getWeight());
    }


    @Test
    void testCompareTo() {
        Edge edge1 = new Edge(0, 1, 10);
        Edge edge2 = new Edge(0, 1, 20);

        assertEquals(0, edge.compareTo(edge1));
        assertEquals(-10, edge.compareTo(edge2));
    }

    @Test
    void testToString() {
        assertEquals("Edge{src=0, dest=1, weight=10}", edge.toString());
    }

    @Test
    void testEquals() {
        Edge edge1 = new Edge(0, 1, 10);
        Edge edge2 = new Edge(0, 2, 10);
        Edge edge3 = new Edge(0, 1, 20);

        assertEquals(true, edge.equals(edge1));
        assertEquals(false, edge.equals(edge2));
        assertEquals(false, edge.equals(edge3));
    }
}