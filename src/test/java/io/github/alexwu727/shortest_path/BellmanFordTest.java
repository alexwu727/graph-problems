package io.github.alexwu727.shortest_path;

import io.github.alexwu727.utils.Edge;
import io.github.alexwu727.utils.Graph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class BellmanFordTest {
    private final Graph graphWithoutNegWeight = new Graph();
    private final Graph graphWithNegWeight = new Graph();

    @BeforeEach
    public void setUp() {
        ArrayList<Edge> edges1 = new ArrayList<>();
        edges1.add(new Edge(0, 1, 4));
        edges1.add(new Edge(0, 3, 7));
        edges1.add(new Edge(0, 4, 17));
        edges1.add(new Edge(1, 2, 12));
        edges1.add(new Edge(1, 4, 8));
        edges1.add(new Edge(2, 3, 6));
        edges1.add(new Edge(3, 4, 2));
        edges1.add(new Edge(4, 2, 4));
        graphWithoutNegWeight.addEdges(edges1);

        ArrayList<Edge> edges2 = new ArrayList<>();
        edges2.add(new Edge(0, 1, 10));
        edges2.add(new Edge(0, 5, 8));
        edges2.add(new Edge(1, 3, 2));
        edges2.add(new Edge(2, 1, 1));
        edges2.add(new Edge(3, 2, -2));
        edges2.add(new Edge(4, 1, -4));
        edges2.add(new Edge(4, 3, -1));
        edges2.add(new Edge(5, 4, 1));
        graphWithNegWeight.addEdges(edges2);
    }

    @Test
    void bellmanFord_OnGraphWithoutNegWeight_StartWithNode0() {
        HashMap<String, int[]> res = BellmanFord.bellmanFord(graphWithoutNegWeight, 0);
        int[] dist = res.get("dist");
        int[] prev = res.get("prev");
        int[] expectedDist = new int[] {0, 4, 13, 7, 9};
        int[] expectedPrev = new int[] {-1, 0, 4, 0, 3};
        assertArrayEquals(expectedDist, dist);
        assertArrayEquals(expectedPrev, prev);
    }

    @Test
    void bellmanFord_OnGraphWithoutNegWeight_StartWithNode2() {
        HashMap<String, int[]> res = BellmanFord.bellmanFord(graphWithoutNegWeight, 2);
        int[] dist = res.get("dist");
        int[] prev = res.get("prev");
        int[] expectedDist = new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 6, 8};
        int[] expectedPrev = new int[] {-1, -1, -1, 2, 3};
        assertArrayEquals(expectedDist, dist);
        assertArrayEquals(expectedPrev, prev);
    }

    @Test
    void bellmanFord_OnGraphWithNegWeight_StartWithNode0() {
        HashMap<String, int[]> res = BellmanFord.bellmanFord(graphWithNegWeight, 0);
        int[] dist = res.get("dist");
        int[] prev = res.get("prev");
        int[] expectedDist = new int[] {0, 5, 5, 7, 9, 8};
        int[] expectedPrev = new int[] {-1, 4, 3, 1, 5, 0};
        assertArrayEquals(expectedDist, dist);
        assertArrayEquals(expectedPrev, prev);
    }

    @Test
    void bellmanFord_OnGraphWithNegWeight_StartWithNode2() {
        HashMap<String, int[]> res = BellmanFord.bellmanFord(graphWithNegWeight, 2);
        int[] dist = res.get("dist");
        int[] prev = res.get("prev");
        int[] expectedDist = new int[] {Integer.MAX_VALUE, 1, 0, 3, Integer.MAX_VALUE, Integer.MAX_VALUE};
        int[] expectedPrev = new int[] {-1, 2, -1, 1, -1, -1};
        assertArrayEquals(expectedDist, dist);
        assertArrayEquals(expectedPrev, prev);
    }
}