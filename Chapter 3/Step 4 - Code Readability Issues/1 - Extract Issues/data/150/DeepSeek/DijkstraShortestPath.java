import java.util.*;

public class DijkstraShortestPath {
    private static class Edge {
        int target;
        int weight;

        Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    public static List<Integer> findShortestPath(List<List<Edge>> graph, int start, int end) {
        int n = graph.size();
        int[] distances = new int[n];
        int[] previous = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        Arrays.fill(previous, -1);
        distances[start] = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(i -> distances[i]));
        pq.add(start);

        while (!pq.isEmpty()) {
            int current = pq.poll();
            if (current == end) break;

            for (Edge edge : graph.get(current)) {
                int newDist = distances[current] + edge.weight;
                if (newDist < distances[edge.target]) {
                    distances[edge.target] = newDist;
                    previous[edge.target] = current;
                    pq.add(edge.target);
                }
            }
        }

        // Reconstruct path
        List<Integer> path = new ArrayList<>();
        for (int at = end; at != -1; at = previous[at]) {
            path.add(at);
        }
        Collections.reverse(path);
        return path.get(0) == start ? path : Collections.emptyList();
    }

    public static void main(String[] args) {
        // Example usage
        int n = 5; // Number of nodes
        List<List<Edge>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // Add edges (directed graph)
        graph.get(0).add(new Edge(1, 4));
        graph.get(0).add(new Edge(2, 1));
        graph.get(1).add(new Edge(3, 1));
        graph.get(2).add(new Edge(1, 2));
        graph.get(2).add(new Edge(3, 5));
        graph.get(3).add(new Edge(4, 3));

        List<Integer> path = findShortestPath(graph, 0, 4);
        System.out.println("Shortest path: " + path); // [0, 2, 1, 3, 4]
    }
}
