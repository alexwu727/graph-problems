package io.github.alexwu727.shortest_path;

import io.github.alexwu727.utils.Edge;
import io.github.alexwu727.utils.Graph;
import io.github.alexwu727.utils.Printer;

import java.util.Arrays;
import java.util.HashMap;

public class BellmanFord {
    public static HashMap<String, int[]> bellmanFord(Graph graph, int startNode) {
        int n = graph.getNumNodes();
        HashMap<String, int[]> res = new HashMap<>();
        int[] dist = new int[n];
        int[] prev = new int[n];
        res.put("dist", dist);
        res.put("prev", prev);
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(prev, -1);
        dist[startNode] = 0;
        for (int i = 0; i < n; i++) {
            boolean updated = false;
            for (int curr = 0; curr < n; curr++) {
                if (dist[curr] == Integer.MAX_VALUE) continue;
                // update dist
                for (Edge edge : graph.getOutDegreeEdges(curr)) {
                    int nei = edge.getDest();
                    if (dist[nei] > dist[curr] + edge.getWeight()) {
                        dist[nei] = dist[curr] + edge.getWeight();
                        prev[nei] = curr;
                        updated = true;
                    }
                }
            }
//            Printer.printArray("dist", dist);
            if (!updated) break;
        }

        return res;
    }
}
