package io.github.alexwu727.minimum_spanning_tree;

import io.github.alexwu727.utils.Edge;
import io.github.alexwu727.data_structures.UnionFind;
import io.github.alexwu727.utils.Graph;
import io.github.alexwu727.utils.Node;

import java.util.ArrayList;

public class Kruskal {
    public static Graph kruskal(Graph graph) {
        Graph mst = new Graph();
        UnionFind unionFind = new UnionFind(graph.getNumNodes());
        ArrayList<Edge> edges = graph.getEdges();
        edges.sort(Edge::compareTo);

        for (Edge edge : edges) {
            int src = edge.getSrc();
            int dest = edge.getDest();
            if (unionFind.find(src) != unionFind.find(dest)) {
                mst.addEdge(edge);
                unionFind.union(src, dest);
            }
        }

        return mst;
    }
}

