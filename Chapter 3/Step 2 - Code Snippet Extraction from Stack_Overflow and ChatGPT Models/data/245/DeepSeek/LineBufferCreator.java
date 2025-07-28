import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.PrecisionModel;
import org.locationtech.jts.operation.buffer.BufferOp;
import org.locationtech.jts.operation.buffer.BufferParameters;

public class LineBufferCreator {
    
    // SRID for WGS84 (latitude/longitude)
    private static final int SRID = 4326;
    
    // Earth's radius in kilometers
    private static final double EARTH_RADIUS_KM = 6371.0;
    
    public static void main(String[] args) {
        // Create a geometry factory
        GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(), SRID);
        
        // Create a sample line (coordinates in degrees)
        Coordinate[] coordinates = new Coordinate[] {
            new Coordinate(-0.1275, 51.5072), // London
            new Coordinate(-74.0060, 40.7128) // New York
        };
        
        LineString line = geometryFactory.createLineString(coordinates);
        
        // Create a 1km buffer around the line
        Geometry buffer = createBuffer(line, 1.0);
        
        System.out.println("Original line: " + line);
        System.out.println("Buffer (1km): " + buffer);
    }
    
    /**
     * Creates a buffer around a line with specified distance in kilometers
     * @param line The line to buffer
     * @param distanceKm The buffer distance in kilometers
     * @return The buffered geometry
     */
    public static Geometry createBuffer(LineString line, double distanceKm) {
        // Convert kilometers to degrees (approximate)
        // This is a simplified approach - for more accuracy, consider using a proper projection
        double distanceDegrees = (distanceKm / EARTH_RADIUS_KM) * (180 / Math.PI);
        
        // Create buffer parameters (you can customize these)
        BufferParameters bufferParams = new BufferParameters();
        
        // Create the buffer
        return BufferOp.bufferOp(line, distanceDegrees, bufferParams);
    }
}
