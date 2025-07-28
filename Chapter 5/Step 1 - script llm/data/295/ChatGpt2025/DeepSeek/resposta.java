import java.util.*;

public class Dijkstra {

    // Method to find the vertex with minimum distance value, from
    // the set of vertices not yet included in shortest path tree
    private static int minDistance(int[] dist, boolean[] sptSet) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        
        for (int vertex = 0; vertex < dist.length; vertex++) {
            if (!sptSet[vertex] && dist[vertex] <= min) {
                min = dist[vertex];
                minIndex = vertex;
            }
        }
        return minIndex;
    }

    // Dijkstra's algorithm implementation
    public static int[] dijkstra(int[][] graph, int src) {
        int vertexCount = graph.length;  // Number of vertices
        int[] dist = new int[vertexCount];  // The output array. dist[i] will hold the shortest distance from src to i
        boolean[] sptSet = new boolean[vertexCount];  // sptSet[i] will be true if vertex i is included in shortest path tree

        // Initialize distances as infinite and sptSet[] as false
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;  // Distance of source vertex from itself is always 0

        // Find shortest path for all vertices
        for (int count = 0; count < vertexCount - 1; count++) {
            int u = minDistance(dist, sptSet);  // Pick the minimum distance vertex from the set of vertices not yet processed
            sptSet[u] = true;  // Mark the picked vertex as processed

            // Update dist value of the adjacent vertices of the picked vertex.
            for (int vertex = 0; vertex < vertexCount; vertex++) {
                // Update dist[vertex] only if it's not in sptSet, there is an edge from u to vertex,
                // and total weight of path from src to vertex through u is smaller than current value of dist[vertex]
                if (!sptSet[vertex] && graph[u][vertex] != 0 && dist[u] != Integer.MAX_VALUE
                    && dist[u] + graph[u][vertex] < dist[vertex]) {
                    dist[vertex] = dist[u] + graph[u][vertex];
                }
            }
        }

        return dist;
    }

    // Driver code
    public static void main(String[] args) {
        int[][] graph = {
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
