package io.github.alexwu727.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class GraphTest {
    private Graph graph;

    @BeforeEach
    public void setUp() {
        ArrayList<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 6));
        edges.add(new Edge(1, 2, 15));

        graph = new Graph(edges);
    }

    @Test
    public void testGraphConstructor_Empty() {
        Graph graph = new Graph();
        assertNotNull(graph);
        assertEquals(0, graph.getNumEdges());
        assertEquals(0, graph.getNumNodes());
        assertEquals(0, graph.getWeight());
    }

    @Test
    public void testGraphConstructor_WithEdges() {
        ArrayList<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 6));
        edges.add(new Edge(1, 2, 15));

        Graph graph = new Graph(edges);
        assertNotNull(graph);
        assertEquals(3, graph.getNumEdges());
        assertEquals(3, graph.getNumNodes());
        assertEquals(31, graph.getWeight());
    }

    @Test
    public void testGraphConstructor_WithNodesAndEdges(){
        ArrayList<Node> nodes = new ArrayList<>();
        nodes.add(new Node(0));
        nodes.add(new Node(1));
        nodes.add(new Node(2));
        nodes.add(new Node(3));

        ArrayList<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 6));
        edges.add(new Edge(1, 2, 15));

        Graph graph = new Graph(edges, nodes);
        assertNotNull(graph);
        assertEquals(3, graph.getNumEdges());
        assertEquals(4, graph.getNumNodes());
        assertEquals(31, graph.getWeight());
    }


    @Test
    void testAddNode() {
        graph.addNode(new Node(3));
        assertEquals(4, graph.getNumNodes());
    }

    @Test
    void testAddNodes() {
        ArrayList<Node> nodes = new ArrayList<>();
        nodes.add(new Node(3));
        nodes.add(new Node(4));
        graph.addNodes(nodes);
        assertEquals(5, graph.getNumNodes());
    }

    @Test
    void testAddEdge_WithEdgeParameter() {
        Edge edge = new Edge(0, 3, 10);
        graph.addEdge(edge);
        assertEquals(4, graph.getNumEdges());
        assertEquals(4, graph.getNumNodes());
        assertEquals(41, graph.getWeight());
        assertEquals(10, graph.getEdges().get(3).getWeight());
    }
    @Test
    void testAddEdge_WithIntParameters() {
        graph.addEdge(0, 3, 10);
        assertEquals(4, graph.getNumEdges());
        assertEquals(4, graph.getNumNodes());
        assertEquals(41, graph.getWeight());
        assertEquals(10, graph.getEdges().get(3).getWeight());
    }

    @Test
    void testAddEdges_WithEdgeArrayParameter() {
        ArrayList<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 3, 10));
        edges.add(new Edge(1, 3, 20));
        graph.addEdges(edges);
        assertEquals(5, graph.getNumEdges());
        assertEquals(4, graph.getNumNodes());
        assertEquals(61, graph.getWeight());
    }

    @Test
    void testAddEdges_WithGraphParameter() {
        Graph graph2 = new Graph();
        graph2.addEdge(0, 3, 10);
        graph2.addEdge(1, 3, 20);
        graph.addEdges(graph2);
        assertEquals(5, graph.getNumEdges());
        assertEquals(4, graph.getNumNodes());
        assertEquals(61, graph.getWeight());
    }

    @Test
    void testClear() {
        graph.clear();
        assertEquals(0, graph.getNumEdges());
        assertEquals(0, graph.getNumNodes());
        assertEquals(0, graph.getWeight());
    }

    @Test
    void testGetNodes() {
        Map<Integer, Node> nodes = graph.getNodes();
        assertEquals(0, nodes.get(0).getId());
        assertEquals(1, nodes.get(1).getId());
        assertEquals(2, nodes.get(2).getId());
    }

    @Test
    void testGetNode(){
        Node node = graph.getNode(0);
        assertEquals(0, node.getId());
    }

    @Test
    void testGetNeighbors(){
        ArrayList<Node> neighbors = graph.getNeighbors(0);
        assertEquals(1, neighbors.get(0).getId());
        assertEquals(2, neighbors.get(1).getId());
    }

    @Test
    void testGetEdges() {
        ArrayList<Edge> edges = graph.getEdges();
        assertEquals(10, edges.get(0).getWeight());
        assertEquals(6, edges.get(1).getWeight());
        assertEquals(15, edges.get(2).getWeight());
    }

    @Test
    void testGetEdges_WithIntParameter() {
        ArrayList<Edge> edges = graph.getEdges(0);
        assertEquals(2, edges.size());
        assertEquals(10, edges.get(0).getWeight());
    }

    @Test
    void testGetInDegreeEdges() {
        ArrayList<Edge> edges = graph.getInDegreeEdges(1);
        assertEquals(1, edges.size());
        assertEquals(10, edges.get(0).getWeight());
    }

    @Test
    void testGetOutDegreeEdges() {
        ArrayList<Edge> edges = graph.getOutDegreeEdges(1);
        assertEquals(1, edges.size());
        assertEquals(15, edges.get(0).getWeight());
    }

    @Test
    void testGetNumNodes() {
        assertEquals(3, graph.getNumNodes());
    }

    @Test
    void testGetNumEdges() {
        assertEquals(3, graph.getNumEdges());
    }

    @Test
    void testGetWeight() {
        assertEquals(31, graph.getWeight());
    }

    @Test
    void testResetVisited() {
        Node node0 = graph.getNodes().get(0);
        Node node1 = graph.getNodes().get(1);
        node0.setVisited(true);
        node1.setVisited(true);
        graph.resetVisited();
        assertFalse(node0.isVisited());
        assertFalse(node1.isVisited());
    }

    @Test
    void testPrintGraph() {
        graph.printGraph();
    }

    @Test
    void testPrintGraph_WithEmptyGraph() {
        Graph graph = new Graph();
        graph.printGraph();
    }

    @Test
    void testPrintNodes() {
        graph.printNodes();
    }

    @Test
    void testPrintNodes_WithEmptyGraph() {
        Graph graph = new Graph();
        graph.printNodes();
    }
}