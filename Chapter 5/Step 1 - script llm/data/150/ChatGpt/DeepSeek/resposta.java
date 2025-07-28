import java.util.*;

public class ShortestPath {
    private static final int INF = Integer.MAX_VALUE;
    private int numVertices;
    private int[][] adjMatrix;

    public ShortestPath(int[][] adjMatrix) {
        this.numVertices = adjMatrix.length;
        this.adjMatrix = adjMatrix;
    }

    public List<Integer> findShortestPath(int source, int dest) {
        int[] distances = new int[numVertices];
        boolean[] visited = new boolean[numVertices];
        int[] previous = new int[numVertices];

        // Initialize distances to infinity and visited to false
        Arrays.fill(distances, INF);
        Arrays.fill(visited, false);

        // The distance from the source to itself is 0
        distances[source] = 0;

        // Loop through all the vertices
        for (int i = 0; i < numVertices - 1; i++) {
            // Find the vertex with the minimum distance
            int minVertex = findMinVertex(distances, visited);

            // Mark the vertex as visited
            visited[minVertex] = true;

            // Update the distances to its neighbors
            for (int j = 0; j < numVertices; j++) {
                int weight = adjMatrix[minVertex][j];
                if (weight > 0 && !visited[j]) {
                    int newDistance = distances[minVertex] + weight;
                    if (newDistance < distances[j]) {
                        distances[j] = newDistance;
                        previous[j] = minVertex;
                    }
                }
            }
        }

        // Construct the shortest path from source to dest
        LinkedList<Integer> path = new LinkedList<>();
        int curr = dest;
        while (curr != source) {
            path.addFirst(curr);
            curr = previous[curr];
        }
        path.addFirst(source);
        return path;
    }

    private int findMinVertex(int[] distances, boolean[] visited) {
        int minVertex = -1;
        for (int i = 0; i < numVertices; i++) {
            if (!visited[i] && (minVertex == -1 || distances[i] < distances[minVertex])) {
                minVertex = i;
            }
        }
        return minVertex;
    }

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
      ShortestPath shortestPath = new ShortestPath(graph);
      List<Integer> path = shortestPath.findShortestPath(0, 4);
      System.out.println("Shortest path from node 0 to node 4:");
      for (int vertex : path) {
          System.out.print(vertex + " ");
      }
  }
}
