package io.github.alexwu727.minimum_spanning_tree;

import io.github.alexwu727.utils.Edge;
import io.github.alexwu727.utils.Graph;
import io.github.alexwu727.utils.Node;

import java.util.PriorityQueue;

public class Prims {
    public static Graph prims(Graph graph) {
        int n = graph.getNumNodes();
        int it = 0;
        Graph mst = new Graph();
        boolean[] visited = new boolean[n];
        PriorityQueue<Edge> heap = new PriorityQueue<>();
        // first node
        Node currNode = graph.getNode(0);
        visited[currNode.getId()] = true;
        heap.addAll(graph.getEdges(0));

        // iterate till has n-1 edges
        while (it < n - 1) {
            Edge currEdge = heap.poll();
            int nei;
            assert currEdge != null;
            if (visited[currEdge.getSrc()]) {
                if (visited[currEdge.getDest()]) continue;
                nei = currEdge.getDest();
            } else if (visited[currEdge.getDest()]) {
                nei = currEdge.getSrc();
            } else continue;
            mst.addEdge(currEdge);
            visited[nei] = true;

            // add new neighbor edges into heap
            heap.addAll(graph.getEdges(nei));
            it++;
        }
        return mst;
    }
}
