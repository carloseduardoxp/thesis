import java.util.*;

class Graph {
    private final int vertices;
    private final List<List<Node>> adjList;

    static class Node implements Comparable<Node> {
        int vertex;
        int weight;

        Node(int v, int w) {
            vertex = v;
            weight = w;
        }

        public int compareTo(Node other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    public Graph(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<>();
        for(int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int src, int dest, int weight) {
        adjList.get(src).add(new Node(dest, weight));
        adjList.get(dest).add(new Node(src, weight)); // If undirected
    }

    public int[] dijkstra(int start) {
        int[] dist = new int[vertices];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.vertex;

            for (Node neighbor : adjList.get(u)) {
                int v = neighbor.vertex;
                int weight = neighbor.weight;

                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new Node(v, dist[v]));
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);

        g.addEdge(0, 1, 9);
        g.addEdge(0, 2, 6);
        g.addEdge(0, 3, 5);
        g.addEdge(0, 4, 3);
        g.addEdge(2, 1, 2);
        g.addEdge(2, 3, 4);

        int[] distances = g.dijkstra(0);
        System.out.println("Shortest distances from node 0:");

        for (int i = 0; i < distances.length; i++) {
            System.out.println("To node " + i + " is " + distances[i]);
        }
    }
}
