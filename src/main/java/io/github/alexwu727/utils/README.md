# Utils

This folder contains utility classes that are commonly used across various graph algorithms in this repository.

## Classes

### Graph

A simple representation for a graph, containing a list of edges.

#### Methods

- `addEdge(int src, int dest, int weight)`: Adds an edge to the graph.

### Node

A simple representation for a node in a graph, useful for node-based operations.

#### Fields

- `id`: Unique identifier for the node.
- `visited`: Boolean flag for traversal algorithms.

### Edge

A simple class to represent an edge in a graph, implementing `Comparable` for easy sorting based on weight.

#### Methods

- `compareTo(Edge otherEdge)`: Compares two edges based on their weight.

## Usage

Import the required utilities in your algorithm classes as needed.

## Example

```java
import utils.Edge;
import utils.Graph;

Graph graph = new Graph();
graph.addEdge(0, 1, 10);
graph.addEdge(0, 2, 6);
