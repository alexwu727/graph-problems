package io.github.alexwu727.minimum_spanning_tree;

import io.github.alexwu727.utils.Edge;
import io.github.alexwu727.utils.Graph;
import io.github.alexwu727.utils.Node;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
class PrimTest {

    @Test
    void prims() {
        ArrayList<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 6));
        edges.add(new Edge(1, 2, 15));
        edges.add(new Edge(1, 3, 4));
        edges.add(new Edge(2, 3, 5));

        Graph graph = new Graph(edges);

        Graph mst = Prim.prim(graph);
        assertEquals(3, mst.getNumEdges());
        assertEquals(6, mst.getEdges().get(0).getWeight());
        assertEquals(5, mst.getEdges().get(1).getWeight());
        assertEquals(4, mst.getEdges().get(2).getWeight());
        assertEquals(15, mst.getWeight());
    }
}