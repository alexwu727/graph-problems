package io.github.alexwu727.shortest_path;

import io.github.alexwu727.utils.Edge;
import io.github.alexwu727.utils.Graph;
import io.github.alexwu727.utils.Printer;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class FloydWarshallTest {

    @Test
    void floydWarshall() {
        ArrayList<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 2, -2));
        edges.add(new Edge(1, 0, 4));
        edges.add(new Edge(1, 2, 3));
        edges.add(new Edge(2, 3, 2));
        edges.add(new Edge(3, 1, -1));
        Graph graph = new Graph(edges);

        HashMap<String, int[][]> res = FloydWarshall.floydWarshall(graph);
        int[][] dist = res.get("dist");
        int[][] prev = res.get("prev");
        int[][] expectedDist = new int[][] {
                {0, -1, -2,0},
                {4, 0, 2, 4},
                {5, 1, 0, 2},
                {3, -1, 1, 0}
        };
        int[][] expectedPrev = new int[][] {
                {-1, 3, 0, 2},
                {1, -1, 0, 2},
                {1, 3, -1, 2},
                {1, 3, 0, -1}
        };
//        Printer.printArray("dist", dist);
        assertArrayEquals(expectedDist, dist);
        assertArrayEquals(expectedPrev, prev);
    }
}