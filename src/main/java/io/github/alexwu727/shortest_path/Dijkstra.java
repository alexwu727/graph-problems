package io.github.alexwu727.shortest_path;

import io.github.alexwu727.utils.Edge;
import io.github.alexwu727.utils.Graph;
import io.github.alexwu727.utils.Node;

import java.util.*;

public class Dijkstra {

    public static HashMap<String, int[]> dijkstra (Graph graph, int startNode) {
        int n = graph.getNumNodes();
        boolean[] visited = new boolean[n];
        HashMap<String, int[]> res = new HashMap<>();
        int[] dist = new int[n];
        int[] prev = new int[n];
        res.put("dist", dist);
        res.put("prev", prev);

        int curr = startNode;
        for (int i = 0; i < n; i++) {
            if (i == curr) dist[i] = 0;
            else dist[i] = Integer.MAX_VALUE;
        }
        visited[curr] = true;
        for (int i = 0; i < n-1; i++) {
            // update dist
            for (Edge edge : graph.getEdges(curr)) {
                int nei = edge.getSrc() == curr ? edge.getDest() : edge.getSrc();
                if (dist[nei] > dist[curr] + edge.getWeight()) {
                    dist[nei] = dist[curr] + edge.getWeight();
                    prev[nei] = curr;
                }
            }
            // choose next node
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && dist[j] < min) {
                    min = dist[j];
                    curr = j;
                }
            }
            visited[curr] = true;
        }

        return res;
    }

    private static void display(String name, int[] array) {
        System.out.print(name + ": ");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
