import org.locationtech.jts.geom.*;
import org.locationtech.jts.io.WKTReader;

public class BufferExample {
    public static void main(String[] args) throws Exception {
        // Create a GeometryFactory instance
        GeometryFactory geometryFactory = new GeometryFactory();

        // Example: Create a LineString from coordinates
        Coordinate[] coords = new Coordinate[] {
            new Coordinate(0, 0),
            new Coordinate(2, 2),
            new Coordinate(4, 0)
        };
        LineString line = geometryFactory.createLineString(coords);

        // Buffer distance in units (assumed coordinate units)
        // If your coordinates are in degrees (lat/lon), 
        // you need to project them to meters before buffering.
        double bufferDistance = 1000; // 1 km buffer

        // Create buffer
        Geometry buffer = line.buffer(bufferDistance);

        System.out.println("Original line: " + line);
        System.out.println("Buffered polygon: " + buffer);
    }
}
