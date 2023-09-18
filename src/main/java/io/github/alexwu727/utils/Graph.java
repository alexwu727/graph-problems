package io.github.alexwu727.utils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    private ArrayList<Edge> edges;
    private Map<Integer, Node> nodes;
    private int numNodes;
    private int numEdges;

    public Graph() {
        this.edges = new ArrayList<>();
        this.nodes = new HashMap<>();
    }

    public Graph(ArrayList<Edge> edges) {
        this.edges = edges;
        this.numEdges = edges.size();
        edges.forEach(this::updateNodes);
    }

    public Graph(ArrayList<Edge> edges, ArrayList<Node> nodes) {
        this.edges = edges;
        this.addNodes(nodes);
        this.numEdges = edges.size();
        edges.forEach(this::updateNodes);
    }

    public void addNode(Node node) {
        if (nodes == null) {
            nodes = new HashMap<>();
        }
        nodes.put(node.getId(), node);
        this.numNodes++;
    }

    public void addNodes(ArrayList<Node> nodes) {
        nodes.forEach(this::addNode);
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
        this.numEdges++;
        updateNodes(edge);
    }

    public void addEdge(int src, int dest, int weight) {
        Edge edge = new Edge(src, dest, weight);
        this.addEdge(edge);
    }

    public void addEdges(ArrayList<Edge> edges) {
        edges.forEach(this::addEdge);
    }

    public void addEdges(Graph graph) {
        this.addEdges(graph.getEdges());
    }

    public void clear() {
        this.edges.clear();
        this.nodes.clear();
        this.numEdges = 0;
        this.numNodes = 0;
    }

    private void updateNodes(Edge edge) {
        if (nodes == null) {
            nodes = new HashMap<>();
        }
        int src = edge.getSrc();
        int dest = edge.getDest();
        if (!nodes.containsKey(src)) {
            this.addNode(new Node(src));
        }
        if (!nodes.containsKey(dest)) {
            this.addNode(new Node(dest));
        }
    }

    public Map<Integer, Node> getNodes() {
        return nodes;
    }

    public Node getNode(int id) {
        return nodes.get(id);
    }

    public ArrayList<Node> getNeighbors(int id) {
        ArrayList<Node> neighbors = new ArrayList<>();
        for (Edge edge : edges) {
            if (edge.getSrc() == id) {
                neighbors.add(nodes.get(edge.getDest()));
            }
            if (edge.getDest() == id) {
                neighbors.add(nodes.get(edge.getSrc()));
            }
        }
        return neighbors;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public ArrayList<Edge> getEdges(int nodeId) {
        ArrayList<Edge> res = new ArrayList<>();
        edges.forEach( edge -> {
            if (edge.getSrc() == nodeId || edge.getDest() == nodeId) res.add(edge);
        });
        return res;
    }

    public int getNumNodes() {
        return numNodes;
    }

    public int getNumEdges() {
        return numEdges;
    }

    public void printGraph() {
        if (edges == null || edges.isEmpty()) {
            System.out.println("Graph is empty");
            return;
        }
        System.out.println("Graph: ");
        for (Edge edge : edges) {
            System.out.println(edge);
        }
    }

    public void printNodes() {
        if (nodes == null || nodes.isEmpty()) {
            System.out.println("Nodes are empty");
            return;
        }
        System.out.println("Nodes: ");
        System.out.println(nodes);
    }
}