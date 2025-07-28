import org.geotools.coverage.grid.GridCoverage2D;
import org.geotools.coverage.grid.GridCoverageFactory;
import org.geotools.gce.geotiff.GeoTiffWriter;
import org.geotools.geometry.Envelope2D;
import org.geotools.referencing.CRS;
import org.opengis.referencing.crs.CoordinateReferenceSystem;

import java.awt.image.BufferedImage;
import java.io.File;

public class GeoTiffCreator {

    public static void main(String[] args) throws Exception {
        // Image dimensions
        int width = 100;
        int height = 100;

        // Create a BufferedImage (grayscale)
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);

        // Fill image with sample data (e.g., gradient)
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int gray = (x + y) % 256;  // simple pattern
                int rgb = (gray << 16) | (gray << 8) | gray;
                image.setRGB(x, y, rgb);
            }
        }

        // Define geographic envelope: xmin, ymin, xmax, ymax (world coordinates)
        double xmin = 0;
        double ymin = 0;
        double xmax = 10;
        double ymax = 10;
        Envelope2D envelope = new Envelope2D(null, xmin, ymin, xmax - xmin, ymax - ymin);

        // Define coordinate reference system (CRS) - WGS84 Lat/Lon
        CoordinateReferenceSystem crs = CRS.decode("EPSG:4326");

        // Create the GridCoverage2D (raster + georeferencing)
        GridCoverageFactory factory = new GridCoverageFactory();
        GridCoverage2D coverage = factory.create("MyGeoTIFF", image, envelope, crs, null, null);

        // Write GeoTIFF to file
        File outputFile = new File("output.tif");
        GeoTiffWriter writer = new GeoTiffWriter(outputFile);
        writer.write(coverage, null);
        writer.dispose();

        System.out.println("GeoTIFF file created: " + outputFile.getAbsolutePath());
    }
}
