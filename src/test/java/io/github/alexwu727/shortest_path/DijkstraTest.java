package io.github.alexwu727.shortest_path;

import io.github.alexwu727.utils.Edge;
import io.github.alexwu727.utils.Graph;
import io.github.alexwu727.utils.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class DijkstraTest {

    @Test
    void dijkstra() {
        Graph graph = new Graph();
        Node node0 = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        ArrayList<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 5));
        edges.add(new Edge(0, 3, 10));
        edges.add(new Edge(0, 4, 7));
        edges.add(new Edge(1, 2, 22));
        edges.add(new Edge(1, 4, 3));
        edges.add(new Edge(2, 3, 15));
        edges.add(new Edge(3, 4, 2));


        graph.addEdges(edges);
        HashMap<String, int[]> res = Dijkstra.dijkstra(graph, 0);
        int[] dist = res.get("dist");
        int[] prev = res.get("prev");
        int[] expectedDist = new int[] {0, 5, 24, 9, 7};
        int[] expectedPrev = new int[] {0, 0, 3, 4, 0};
        assertArrayEquals(expectedDist, dist);
        assertArrayEquals(expectedPrev, prev);
    }
}