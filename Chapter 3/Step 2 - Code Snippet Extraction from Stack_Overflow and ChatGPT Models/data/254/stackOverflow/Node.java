
public class Node {
    private final double x, y, z;

    public Node() {
    }

    public Node(final double x, final double y, final double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void setCoordinates(final double x, final double y, final double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public int hashCode() {
        return 31 * 31 * Double.valueOf(x).hashCode()
                + 31 * Double.valueOf(y).hashCode()
                + Double.valueOf(z).hashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Node)) {
            return false;
        }
        Node n = (Node) other;
        return x == n.x && y == n.y && z == n.z;
    }
}
