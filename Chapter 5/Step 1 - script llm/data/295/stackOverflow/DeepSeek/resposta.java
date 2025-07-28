import java.util.*;

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

                    v.minDistance = distanceThroughU;
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
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex d = new Vertex("D");
        Vertex f = new Vertex("F");
        Vertex k = new Vertex("K");
        Vertex j = new Vertex("J");
        Vertex m = new Vertex("M");
        Vertex o = new Vertex("O");
        Vertex p = new Vertex("P");
        Vertex r = new Vertex("R");
        Vertex z = new Vertex("Z");

        a.adjacencies = new Edge[]{ new Edge(m, 8) };
        b.adjacencies = new Edge[]{ new Edge(d, 11) };
        d.adjacencies = new Edge[]{ new Edge(b, 11) };
        f.adjacencies = new Edge[]{ new Edge(k, 23) };
        k.adjacencies = new Edge[]{ new Edge(o, 40) };
        j.adjacencies = new Edge[]{ new Edge(k, 25) };
        m.adjacencies = new Edge[]{ new Edge(r, 8) };
        o.adjacencies = new Edge[]{ new Edge(k, 40) };
        p.adjacencies = new Edge[]{ new Edge(z, 18) };
        r.adjacencies = new Edge[]{ new Edge(p, 15) };
        z.adjacencies = new Edge[]{ new Edge(p, 18) };

        computePaths(a);
        System.out.println("Distance to " + z + ": " + z.minDistance);
        List<Vertex> path = getShortestPathTo(z);
        System.out.println("Path: " + path);
    }
}
