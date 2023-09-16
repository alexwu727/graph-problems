# Minimum Spanning Tree Algorithms

This folder contains Java implementations of Minimum Spanning Tree (MST) algorithms.

## Algorithms

- **Prim's Algorithm**: Finds an MST of a connected, undirected graph with weighted vertices. Time complexity is \(O(E + V \log V)\).
- **Kruskal's Algorithm**: Another algorithm for finding an MST in a weighted, undirected graph. Time complexity is \(O(E \log E)\).

## Usage

Here's how you can run the algorithms:

### Prim's Algorithm:

1. Add your graph definition in the `Graph` class from the `utils` package.
2. Initialize the graph and the starting node.

``` java
Graph graph = new Graph();
// ... (add edges and nodes to the graph)
Node startNode = graph.getNode(startNodeId);
Graph mst = Prims.runPrims(graph, startNode);
```

### Kruskal's Algorithm:

1. Add your graph definition in the `Graph` class from the `utils` package.
2. Initialize the graph.

``` java
Graph graph = new Graph();
// ... (add edges and nodes to the graph)
Graph mst = Kruskal.runKruskal(graph);
```

## Test

You can run the tests for each algorithm from the `test` directory using your IDE's test runner or Maven's test command.

## Additional Resources

- [Prim's Algorithm - Wikipedia](https://en.wikipedia.org/wiki/Prim%27s_algorithm)
- [Kruskal's Algorithm - Wikipedia](https://en.wikipedia.org/wiki/Kruskal%27s_algorithm)
