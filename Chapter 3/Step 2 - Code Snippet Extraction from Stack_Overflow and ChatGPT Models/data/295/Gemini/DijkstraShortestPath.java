import java.util.*;

public class DijkstraShortestPath {

    // Represents an edge in the graph
    static class Edge {
        int destination;
        int weight;

        public Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    // Represents a node in the priority queue
    // Stores the node index and its current shortest distance from the source
    static class Node implements Comparable<Node> {
        int vertex;
        int distance;

        public Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        // Compare based on distance for the PriorityQueue
        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    /**
     * Finds the shortest paths from a source vertex to all other vertices
     * in a weighted graph using Dijkstra's algorithm.
     *
     * @param graph The graph represented as an adjacency list.
     * graph.get(i) is a list of Edge objects representing
     * edges originating from vertex i.
     * @param V     The number of vertices in the graph.
     * @param source The starting vertex for finding shortest paths.
     * @return An array where dist[i] is the shortest distance from the source
     * to vertex i. If a vertex is unreachable, its distance remains
     * Integer.MAX_VALUE.
     */
    public static int[] dijkstra(List<List<Edge>> graph, int V, int source) {
        // dist[i] will store the shortest distance from source to vertex i
        int[] dist = new int[V];
        // Initialize all distances to infinity
        Arrays.fill(dist, Integer.MAX_VALUE);

        // A set to keep track of vertices whose shortest distance has been finalized
        Set<Integer> settled = new HashSet<>();

        // Priority queue to store nodes to be processed, ordered by their distance
        // from the source
        PriorityQueue<Node> pq = new PriorityQueue<>();

        // Distance to the source vertex is 0
        dist[source] = 0;
        pq.add(new Node(source, 0));

        while (!pq.isEmpty()) {
            // Get the node with the minimum distance from the priority queue
            Node currentNode = pq.poll();
            int u = currentNode.vertex;

            // If this node has already been settled, skip it
            if (settled.contains(u)) {
                continue;
            }

            // Mark the current node as settled
            settled.add(u);

            // Explore neighbors of the current node
            for (Edge edge : graph.get(u)) {
                int v = edge.destination;
                int weight = edge.weight;

                // If neighbor 'v' has not been settled yet AND
                // a shorter path to 'v' is found through 'u'
                if (!settled.contains(v) && dist[u] != Integer.MAX_VALUE &&
                    dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new Node(v, dist[v]));
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int V = 5; // Number of vertices
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges to the graph (example)
        // Format: addEdge(source, destination, weight)
        // Edge: 0 -> 1 with weight 4
        graph.get(0).add(new Edge(1, 4));
        // Edge: 0 -> 2 with weight 1
        graph.get(0).add(new Edge(2, 1));
        // Edge: 1 -> 3 with weight 2
        graph.get(1).add(new Edge(3, 2));
        // Edge: 2 -> 1 with weight 2
        graph.get(2).add(new Edge(1, 2));
        // Edge: 2 -> 3 with weight 5
        graph.get(2).add(new Edge(3, 5));
        // Edge: 3 -> 4 with weight 3
        graph.get(3).add(new Edge(4, 3));

        int sourceVertex = 0;
        int[] shortestDistances = dijkstra(graph, V, sourceVertex);

        System.out.println("Shortest distances from source " + sourceVertex + ":");
        for (int i = 0; i < V; i++) {
            if (shortestDistances[i] == Integer.MAX_VALUE) {
                System.out.println("To vertex " + i + ": Unreachable");
            } else {
                System.out.println("To vertex " + i + ": " + shortestDistances[i]);
            }
        }

        System.out.println("\nAnother example:");
        V = 6;
        List<List<Edge>> graph2 = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph2.add(new ArrayList<>());
        }

        graph2.get(0).add(new Edge(1, 7));
        graph2.get(0).add(new Edge(2, 9));
        graph2.get(0).add(new Edge(5, 14));
        graph2.get(1).add(new Edge(2, 10));
        graph2.get(1).add(new Edge(3, 15));
        graph2.get(2).add(new Edge(1, 10));
        graph2.get(2).add(new Edge(3, 11));
        graph2.get(2).add(new Edge(5, 2));
        graph2.get(3).add(new Edge(4, 6));
        graph2.get(4).add(new Edge(3, 6));
        graph2.get(5).add(new Edge(4, 9));

        sourceVertex = 0;
        shortestDistances = dijkstra(graph2, V, sourceVertex);

        System.out.println("Shortest distances from source " + sourceVertex + ":");
        for (int i = 0; i < V; i++) {
            if (shortestDistances[i] == Integer.MAX_VALUE) {
                System.out.println("To vertex " + i + ": Unreachable");
            } else {
                System.out.println("To vertex " + i + ": " + shortestDistances[i]);
            }
        }
    }
}
