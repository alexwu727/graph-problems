package io.github.alexwu727.shortest_path;

import io.github.alexwu727.utils.Edge;
import io.github.alexwu727.utils.Graph;

import java.util.*;

public class Dijkstra {

    public static HashMap<String, int[]> dijkstra (Graph graph, int startNode) {
        int n = graph.getNumNodes();
        boolean[] visited = new boolean[n];
        int[] dist = new int[n];
        int[] prev = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(prev, -1);
        dist[startNode] = 0;
        HashMap<String, int[]> res = new HashMap<>();
        res.put("dist", dist);
        res.put("prev", prev);
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> dist[a] - dist[b]);
        heap.add(startNode);
        while (!heap.isEmpty()) {
            int curr = heap.poll();
            if (visited[curr]) continue;
            visited[curr] = true;
            // update dist
            for (Edge edge : graph.getEdges(curr)) {
                int nei = edge.getSrc() == curr ? edge.getDest() : edge.getSrc();
                if (visited[nei]) continue;
                if (dist[nei] > dist[curr] + edge.getWeight()) {
                    dist[nei] = dist[curr] + edge.getWeight();
                    prev[nei] = curr;
                    heap.add(nei);
                }
            }
        }
        return res;
    }
}
