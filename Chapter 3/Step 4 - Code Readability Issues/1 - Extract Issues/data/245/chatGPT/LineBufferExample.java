import com.vividsolutions.jts.geom.*;
import com.vividsolutions.jts.io.*;

public class LineBufferExample {
    public static void main(String[] args) throws ParseException {
        // create a line
        WKTReader reader = new WKTReader();
        LineString line = (LineString) reader.read("LINESTRING (0 0, 5 5)");

        // create a buffer around the line
        GeometryFactory factory = new GeometryFactory();
        double distance = 1; // in kilometers
        int numSegments = 8; // optional, number of segments to use for the buffer
        BufferOp bufferOp = new BufferOp(line, factory);
        Geometry buffer = bufferOp.getResultGeometry(distance * 1000, numSegments);

        // print the buffer
        WKTWriter writer = new WKTWriter();
        System.out.println(writer.write(buffer));
    }
}
