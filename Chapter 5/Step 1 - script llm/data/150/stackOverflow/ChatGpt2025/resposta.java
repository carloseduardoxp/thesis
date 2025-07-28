import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Vertex implements Comparable<Vertex>
{
    public final String name;
    public Edge[] adjacencies;
    public double minDistance = Double.POSITIVE_INFINITY;
    public Vertex previous;
    public Vertex(String argName) { name = argName; }
    public String toString() { return name; }
    public int compareTo(Vertex other)
    {
        return Double.compare(minDistance, other.minDistance);
    }
}

class Edge
{
    public final Vertex target;
    public final double weight;
    public Edge(Vertex argTarget, double argWeight)
    { target = argTarget; weight = argWeight; }
}

public class Dijkstra
{
    public static void computePaths(Vertex source)
    {
        source.minDistance = 0.;
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<>();

        vertexQueue.add(source);

        while (!vertexQueue.isEmpty()) {
            Vertex u = vertexQueue.poll();

            // Visit each edge exiting u
            for (Edge e : u.adjacencies)
            {
                Vertex v = e.target;
                double weight = e.weight;
                double distanceThroughU = u.minDistance + weight;
                if (distanceThroughU < v.minDistance) {
                    vertexQueue.remove(v);

                    v.minDistance = distanceThroughU ;
                    v.previous = u;
                    vertexQueue.add(v);
                }
            }
        }
    }

    public static List<Vertex> getShortestPathTo(Vertex target)
    {
        List<Vertex> path = new ArrayList<>();
        for (Vertex vertex = target; vertex != null; vertex = vertex.previous)
            path.add(vertex);

        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args)
    {
        // mark all the vertices 
        Vertex vertexA = new Vertex("A");
        Vertex vertexB = new Vertex("B");
        Vertex vertexD = new Vertex("D");
        Vertex vertexF = new Vertex("F");
        Vertex vertexK = new Vertex("K");
        Vertex vertexJ = new Vertex("J");
        Vertex vertexM = new Vertex("M");
        Vertex vertexO = new Vertex("O");
        Vertex vertexP = new Vertex("P");
        Vertex vertexR = new Vertex("R");
        Vertex vertexZ = new Vertex("Z");

        // set the edges and weight
        vertexA.adjacencies = new Edge[]{ new Edge(vertexM, 8) };
        vertexB.adjacencies = new Edge[]{ new Edge(vertexD, 11) };
        vertexD.adjacencies = new Edge[]{ new Edge(vertexB, 11) };
        vertexF.adjacencies = new Edge[]{ new Edge(vertexK, 23) };
        vertexK.adjacencies = new Edge[]{ new Edge(vertexO, 40) };
        vertexJ.adjacencies = new Edge[]{ new Edge(vertexK, 25) };
        vertexM.adjacencies = new Edge[]{ new Edge(vertexR, 8) };
        vertexO.adjacencies = new Edge[]{ new Edge(vertexK, 40) };
        vertexP.adjacencies = new Edge[]{ new Edge(vertexZ, 18) };
        vertexR.adjacencies = new Edge[]{ new Edge(vertexP, 15) };
        vertexZ.adjacencies = new Edge[]{ new Edge(vertexP, 18) };

        computePaths(vertexA); // run Dijkstra
        System.out.println("Distance to " + vertexZ + ": " + vertexZ.minDistance);
        List<Vertex> path = getShortestPathTo(vertexZ);
        System.out.println("Path: " + path);
    }
}
