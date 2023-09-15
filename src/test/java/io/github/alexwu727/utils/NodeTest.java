package io.github.alexwu727.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {
    @Test
    public void testNodeFields() {
        Node node = new Node(1);

        assertEquals(1, node.id);
        assertEquals(false, node.visited);
    }
}