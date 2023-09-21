# Minimum Spanning Tree Algorithms

This folder contains Java implementations of two popular algorithms for finding the Minimum Spanning Tree of a weighted graph: Prim's and Kruskal's Algorithms.

## Algorithms

### Prim's Algorithm

#### Description

Prim's Algorithm starts from an arbitrary node and greedily selects the edge with the smallest weight to extend the tree.

#### Time Complexity

1. **With Binary Heap**:
    - Insertion and extraction each take O(log V) time.
    - In the worst case, you'll insert and extract every vertex and edge.
    - Overall time complexity: O((V + E) log V)

2. **With Fibonacci Heap**:
    - Insertion is O(1) and extraction is O(log V).
    - Overall time complexity: O(E + V log V)

#### Space Complexity

- The adjacency list requires O(V + E) space.
- The heap/priority queue will take up O(V) space.
- Overall: O(V + E)
- 
#### When to Use
- Preferable for dense graphs where E approx V^2.
- Not suitable for disconnected graphs unless modified.

---

### Kruskal's Algorithm

#### Description

Kruskal's Algorithm sorts all the edges by weight and then iteratively adds the smallest edge that doesn't form a cycle until the MST is formed.

#### Time Complexity

- Sorting the edges takes O(E log E) time.
- Union-Find operations take O(log V) time.
- Overall time complexity: O(E log E + (V + E) log V)

#### Space Complexity

- O(V + E) for storing the graph.
- O(V) for the Union-Find data structure.
- Overall: O(V + E)

#### When to Use
- Effective for sparse graphs where E is much less than V^2.
- Good for disconnected graphs.

---

## When to Use Which?

- **Dense Graphs**: Prim's is generally more efficient.
- **Sparse Graphs**: Kruskal's could be more beneficial.
- **Disconnected Graph**: Kruskal's is the way to go.



## Usage

Here's how you can run the algorithms:

### Prim's Algorithm:

1. Add your graph definition in the `Graph` class from the `utils` package.
2. Initialize the graph and the starting node.

``` java
Graph graph = new Graph();
// ... (add edges and nodes to the graph)
Graph mst = Prim.prim(graph);
```

### Kruskal's Algorithm:

1. Add your graph definition in the `Graph` class from the `utils` package.
2. Initialize the graph.

``` java
Graph graph = new Graph();
// ... (add edges and nodes to the graph)
Graph mst = Kruskal.kruskal(graph);
```

## Test

You can run the tests for each algorithm from the `test` directory using your IDE's test runner or Maven's test command.

## Additional Resources

- [Prim's Algorithm - Wikipedia](https://en.wikipedia.org/wiki/Prim%27s_algorithm)
- [Kruskal's Algorithm - Wikipedia](https://en.wikipedia.org/wiki/Kruskal%27s_algorithm)
