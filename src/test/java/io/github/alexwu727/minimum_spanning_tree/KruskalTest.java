package io.github.alexwu727.minimum_spanning_tree;

import io.github.alexwu727.utils.Edge;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class KruskalTest {

    @Test
    void kruskal() {
        ArrayList<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 6));
        edges.add(new Edge(0, 3, 5));
        edges.add(new Edge(1, 3, 15));
        edges.add(new Edge(2, 3, 4));

        ArrayList<Edge> mst = Kruskal.kruskal(edges, 4);
        assertEquals(3, mst.size());
        assertEquals(2, mst.get(0).src);
        assertEquals(3, mst.get(0).dest);
        assertEquals(4, mst.get(0).weight);
        assertEquals(0, mst.get(1).src);
        assertEquals(3, mst.get(1).dest);
        assertEquals(5, mst.get(1).weight);
        assertEquals(0, mst.get(2).src);
        assertEquals(1, mst.get(2).dest);
        assertEquals(10, mst.get(2).weight);
    }
}