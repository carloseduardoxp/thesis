import java.util.*;

public class Dijkstra {

    // Method to find the vertex with minimum distance value, from
    // the set of vertices not yet included in shortest path tree
    private static int minDistance(int[] dist, boolean[] sptSet) {
        int min = Integer.MAX_VALUE, minIndex = -1;
        
        for (int v = 0; v < dist.length; v++) {
            if (!sptSet[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    // Dijkstra's algorithm implementation
    public static int[] dijkstra(int[][] graph, int src) {
        int V = graph.length;  // Number of vertices
        int[] dist = new int[V];  // The output array. dist[i] will hold the shortest distance from src to i
        boolean[] sptSet = new boolean[V];  // sptSet[i] will be true if vertex i is included in shortest path tree

        // Initialize distances as infinite and sptSet[] as false
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;  // Distance of source vertex from itself is always 0

        // Find shortest path for all vertices
        for (int count = 0; count < V - 1; count++) {
            int u = minDistance(dist, sptSet);  // Pick the minimum distance vertex from the set of vertices not yet processed
            sptSet[u] = true;  // Mark the picked vertex as processed

            // Update dist value of the adjacent vertices of the picked vertex.
            for (int v = 0; v < V; v++) {
                // Update dist[v] only if it's not in sptSet, there is an edge from u to v,
                // and total weight of path from src to v through u is smaller than current value of dist[v]
                if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE
                    && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        return dist;
    }

    // Driver code
    public static void main(String[] args) {
        int graph[][] = new int[][] {
            {0, 4, 0, 0, 0, 0, 0, 8, 0},
            {4, 0, 8, 0, 0, 0, 0, 11, 0},
            {0, 8, 0, 7, 0, 4, 0, 0, 2},
            {0, 0, 7, 0, 9, 14, 0, 0, 0},
            {0, 0, 0, 9, 0, 10, 0, 0, 0},
            {0, 0, 4, 14, 10, 0, 2, 0, 0},
            {0, 0, 0, 0, 0, 2, 0, 1, 6},
            {8, 11, 0, 0, 0, 0, 1, 0, 7},
            {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
        
        int source = 0;
        int[] distances = dijkstra(graph, source);
        
        System.out.println("Vertex \t Distance from Source " + source);
        for (int i = 0; i < distances.length; i++) {
            System.out.println(i + " \t\t " + distances[i]);
        }
    }
}
