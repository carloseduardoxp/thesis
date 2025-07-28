import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.PrecisionModel;
import org.locationtech.jts.io.WKTWriter;

public class LineBufferExample {

    public static void main(String[] args) {
        // 1. Create a GeometryFactory
        // Use a default precision model and SRID (Spatial Reference ID, 0 by default)
        GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(), 0);

        // 2. Define Your Line Coordinates
        // These coordinates are illustrative and should be in a projected CRS (e.g., UTM)
        // where 1 unit = 1 meter.
        // For example, if these were UTM coordinates (zone 23S for Uberlândia, Brazil):
        // Approx. coordinates for a line segment near Uberlândia, Brazil (in UTM 23S)
        // These are illustrative; replace with your actual projected coordinates.
        Coordinate[] lineCoordinates = new Coordinate[]{
                new Coordinate(300000, 8100000), // Easting, Northing
                new Coordinate(301000, 8101000),
                new Coordinate(302000, 8100500)
        };

        // 3. Create a LineString
        LineString line = geometryFactory.createLineString(lineCoordinates);

        // 4. Perform the Buffer Operation
        // Buffer distance in meters (1000 meters = 1 km)
        double bufferDistance = 1000.0;
        // The `quadrantSegments` parameter controls the number of segments used to approximate a quarter circle.
        // A higher value results in a smoother buffer but more vertices. 8 or 16 are common values.
        int quadrantSegments = 8;
        Geometry bufferPolygon = line.buffer(bufferDistance, quadrantSegments);

        // 5. Output the result (e.g., as Well-Known Text - WKT)
        WKTWriter wktWriter = new WKTWriter();
        System.out.println("Original Line WKT: " + wktWriter.write(line));
        System.out.println("1km Buffer Polygon WKT: " + wktWriter.write(bufferPolygon));

        // You can now use 'bufferPolygon' for further spatial analysis,
        // display on a map, or save to a spatial database.
    }
}
