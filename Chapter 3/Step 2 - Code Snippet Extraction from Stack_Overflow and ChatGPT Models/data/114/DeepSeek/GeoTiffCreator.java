import org.geotools.coverage.grid.GridCoverage2D;
import org.geotools.coverage.grid.GridCoverageFactory;
import org.geotools.gce.geotiff.GeoTiffWriter;
import org.geotools.geometry.jts.ReferencedEnvelope;
import org.geotools.referencing.crs.DefaultGeographicCRS;
import org.opengis.referencing.crs.CoordinateReferenceSystem;

import java.awt.image.BufferedImage;
import java.io.File;

public class GeoTiffCreator {

    public static void main(String[] args) throws Exception {
        // Define the CRS (Coordinate Reference System) - WGS84 in this case
        CoordinateReferenceSystem crs = DefaultGeographicCRS.WGS84;
        
        // Define the geographic bounds (minX, maxX, minY, maxY)
        ReferencedEnvelope envelope = new ReferencedEnvelope(
            -180.0, 180.0, -90.0, 90.0, crs);
        
        // Create a simple image (width, height)
        int width = 360;
        int height = 180;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        
        // Fill the image with some data (example: gradient)
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int value = (x + y) % 256;
                int rgb = (value << 16) | (value << 8) | value;
                image.setRGB(x, y, rgb);
            }
        }
        
        // Create a grid coverage from the image
        GridCoverageFactory factory = new GridCoverageFactory();
        GridCoverage2D coverage = factory.create("my_coverage", image, envelope);
        
        // Write the GeoTIFF file
        File geoTiffFile = new File("output.tif");
        GeoTiffWriter writer = new GeoTiffWriter(geoTiffFile);
        writer.write(coverage, null);
        writer.dispose();
        
        System.out.println("GeoTIFF created: " + geoTiffFile.getAbsolutePath());
    }
}
