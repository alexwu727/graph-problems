package io.github.alexwu727.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {
    private Node node;
    @BeforeEach
    public void setUp() {
        node = new Node(1);
    }
    @Test
    public void testNodeConstructor() {
        Node node = new Node(1);

        assertEquals(1, node.getId());
        assertEquals(false, node.isVisited());
    }

    @Test
    public void testGetId() {
        assertEquals(1, node.getId());
    }

    @Test
    public void testIsVisited() {
        assertEquals(false, node.isVisited());
    }

    @Test
    public void testSetVisited() {
        node.setVisited(true);
        assertEquals(true, node.isVisited());
    }

    @Test
    public void testToString() {
        assertEquals("Node{id=1, visited=false}", node.toString());
    }

    @Test
    public void testEquals() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(1);
        assertEquals(true, node.equals(node1));
        assertEquals(false, node.equals(node2));
        assertEquals(true, node.equals(node3));
    }
}