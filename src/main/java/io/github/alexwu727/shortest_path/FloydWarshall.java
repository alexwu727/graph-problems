package io.github.alexwu727.shortest_path;

import io.github.alexwu727.utils.Edge;
import io.github.alexwu727.utils.Graph;
import io.github.alexwu727.utils.Printer;

import java.util.Arrays;
import java.util.HashMap;

public class FloydWarshall {
    public static HashMap<String, int[][]> floydWarshall(Graph graph) {
        int n = graph.getNumNodes();
        int[][] dist = new int[n][n];
        int[][] prev = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            Arrays.fill(prev[i], -1);
        }
        HashMap<String, int[][]> res = new HashMap<>();
        res.put("dist", dist);
        res.put("prev", prev);
        for (int i = 0; i < n; i++) {
            dist[i][i] = 0;
        }
        for (Edge edge : graph.getEdges()) {
            int src = edge.getSrc();
            int dest = edge.getDest();
            dist[src][dest] = edge.getWeight();
            prev[src][dest] = src;
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if ((dist[i][k] == Integer.MAX_VALUE) || (dist[k][j] == Integer.MAX_VALUE)) continue;
                    int newDist = dist[i][k] + dist[k][j];
                    if (dist[i][j] > newDist) {
                        dist[i][j] = newDist;
                        prev[i][j] = prev[k][j];
                    }
                }
            }
        }

        return res;
    }
}
