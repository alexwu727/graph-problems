package io.github.alexwu727.minimum_spanning_tree;

import io.github.alexwu727.utils.Edge;
import io.github.alexwu727.data_structures.UnionFind;

import java.util.ArrayList;

public class Kruskal {
    public static ArrayList<Edge> kruskal(ArrayList<Edge> edges, int numNodes) {
        ArrayList<Edge> mst = new ArrayList<>();
        UnionFind unionFind = new UnionFind(numNodes);

        edges.sort(Edge::compareTo);

        for (Edge edge : edges) {
            if (unionFind.find(edge.src) != unionFind.find(edge.dest)) {
                mst.add(edge);
                unionFind.union(edge.src, edge.dest);
            }
        }

        return mst;
    }
}

