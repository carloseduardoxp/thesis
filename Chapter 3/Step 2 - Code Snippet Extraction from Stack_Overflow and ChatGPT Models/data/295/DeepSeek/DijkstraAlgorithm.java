import java.util.*;

public class DijkstraAlgorithm {

    // Class to represent a node in the graph
    static class Node implements Comparable<Node> {
        int vertex;
        int distance;

        public Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    // Dijkstra's algorithm to find shortest paths from source to all other vertices
    public static int[] dijkstra(List<List<Node>> graph, int source) {
        int n = graph.size();
        int[] distances = new int[n];
        boolean[] visited = new boolean[n];
        PriorityQueue<Node> minHeap = new PriorityQueue<>();

        // Initialize all distances as infinite
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0;
        minHeap.add(new Node(source, 0));

        while (!minHeap.isEmpty()) {
            Node currentNode = minHeap.poll();
            int u = currentNode.vertex;

            // Skip if we've already found a better path
            if (visited[u]) continue;
            visited[u] = true;

            // Check all adjacent vertices
            for (Node neighbor : graph.get(u)) {
                int v = neighbor.vertex;
                int weight = neighbor.distance;

                // Relaxation step
                if (!visited[v] && distances[u] + weight < distances[v]) {
                    distances[v] = distances[u] + weight;
                    minHeap.add(new Node(v, distances[v]));
                }
            }
        }

        return distances;
    }

    public static void main(String[] args) {
        // Example usage
        int vertices = 5;
        int source = 0;

        // Create adjacency list representation of the graph
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges (vertex, weight)
        graph.get(0).add(new Node(1, 4));
        graph.get(0).add(new Node(2, 1));
        graph.get(1).add(new Node(3, 1));
        graph.get(2).add(new Node(1, 2));
        graph.get(2).add(new Node(3, 5));
        graph.get(3).add(new Node(4, 3));

        // Run Dijkstra's algorithm
        int[] distances = dijkstra(graph, source);

        // Print the shortest distances from source to all vertices
        System.out.println("Shortest distances from vertex " + source + ":");
        for (int i = 0; i < distances.length; i++) {
            System.out.println("Vertex " + i + ": " + distances[i]);
        }
    }
}
