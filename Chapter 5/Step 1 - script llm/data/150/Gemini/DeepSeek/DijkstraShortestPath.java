import java.util.*;

// Represents a node/vertex in the graph
class Node implements Comparable<Node> {
    String name;
    double minDistance = Double.POSITIVE_INFINITY;
    Node previous; // To reconstruct the path
    List<Edge> adjacencies;

    public Node(String name) {
        this.name = name;
        this.adjacencies = new ArrayList<>();
    }

    public void addEdge(Edge edge) {
        this.adjacencies.add(edge);
    }

    @Override
    public int compareTo(Node other) {
        return Double.compare(minDistance, other.minDistance);
    }

    @Override
    public String toString() {
        return name;
    }
}

// Represents an edge/connection between two nodes
class Edge {
    Node target;
    double weight;

    public Edge(Node target, double weight) {
        this.target = target;
        this.weight = weight;
    }
}

public class DijkstraShortestPath {

    public static void computePaths(Node source) {
        source.minDistance = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(source);

        while (!pq.isEmpty()) {
            Node u = pq.poll(); // Node with the smallest distance

            // Visit each edge outgoing from u
            for (Edge e : u.adjacencies) {
                Node v = e.target;
                double weight = e.weight;
                double distanceThroughU = u.minDistance + weight;

                if (distanceThroughU < v.minDistance) {
                    pq.remove(v); // Remove and re-add to update priority
                    v.minDistance = distanceThroughU;
                    v.previous = u;
                    pq.add(v);
                }
            }
        }
    }

    public static List<Node> getShortestPathTo(Node target) {
        List<Node> path = new ArrayList<>();
        for (Node node = target; node != null; node = node.previous) {
            path.add(node);
        }
        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        // Create nodes
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");

        // Add edges
        nodeA.addEdge(new Edge(nodeB, 10));
        nodeA.addEdge(new Edge(nodeC, 5));
        nodeB.addEdge(new Edge(nodeD, 1));
        nodeC.addEdge(new Edge(nodeB, 3));
        nodeC.addEdge(new Edge(nodeD, 9));
        nodeC.addEdge(new Edge(nodeE, 2));
        nodeD.addEdge(new Edge(nodeE, 4));

        // Compute shortest paths from A
        computePaths(nodeA);

        // Get shortest path to E
        List<Node> path = getShortestPathTo(nodeE);
        System.out.println("Shortest path from A to E: " + path);
        System.out.println("Distance from A to E: " + nodeE.minDistance);

        // Example for another destination
        List<Node> pathToD = getShortestPathTo(nodeD);
        System.out.println("Shortest path from A to D: " + pathToD);
        System.out.println("Distance from A to D: " + nodeD.minDistance);
    }
}