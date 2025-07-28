import org.geotools.coverage.GridCoverage2D;
import org.geotools.coverage.GridCoverageFactory;
import org.geotools.coverage.io.Abstract;
import org.geotools.gce.geotiff.GeoTiffFormat;
import org.geotools.referencing.CRS;
import org.geotools.util.factory.Hints;
import org.opengis.coverage.grid.GridCoverageReader;
import org.opengis.coverage.grid.GridCoverageWriter;
import org.opengis.referencing.crs.CoordinateReferenceSystem;

import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.spi.ImageWriterSpi;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class GeoTiffCreator {

    public static void main(String[] args) {
        // Define output file path
        File outputFile = new File("output_geotiff.tif");

        // 1. Create a simple BufferedImage (raster data)
        int width = 100;
        int height = 100;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
        WritableRaster raster = image.getRaster();

        // Fill the image with a simple gradient (for demonstration)
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                // Create a simple grayscale gradient from 0 to 255
                int grayValue = (int) (255.0 * ((double) x / width));
                raster.setSample(x, y, 0, grayValue);
            }
        }

        // 2. Define the Coordinate Reference System (CRS)
        // Using WGS84 (EPSG:4326) which is common for lat/lon
        CoordinateReferenceSystem crs = null;
        try {
            crs = CRS.decode("EPSG:4326");
        } catch (Exception e) {
            System.err.println("Error decoding CRS: " + e.getMessage());
            e.printStackTrace();
            return;
        }

        // 3. Define the Georeferencing Transformation
        // This is a simple affine transformation (scale and translate)
        // We'll place the top-left corner of the image at (longitude: 0, latitude: 0)
        // and each pixel will represent 0.1 degrees.
        // The image will extend from (0,0) to (10,10) degrees.
        double originX = 0.0;  // Longitude of top-left pixel
        double originY = 0.0;  // Latitude of top-left pixel
        double pixelSizeX = 0.1; // Degrees per pixel in X direction
        double pixelSizeY = -0.1; // Degrees per pixel in Y direction (negative for "north up" images)

        // Create a GridCoverageFactory to build the GridCoverage2D
        GridCoverageFactory factory = new GridCoverageFactory(new Hints(Hints.CRS, crs));

        // Create the GridCoverage2D object
        // This combines the image data with the georeferencing information
        GridCoverage2D coverage = factory.create("MyGeoTiff", image, originX, originY, pixelSizeX, pixelSizeY);

        // 4. Get a GeoTIFF Writer
        GeoTiffFormat format = new GeoTiffFormat();
        GridCoverageWriter writer = null;
        ImageOutputStream outputStream = null;

        try {
            // Get an ImageWriter for GeoTIFF format
            Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("GeoTIFF");
            if (!writers.hasNext()) {
                System.err.println("No GeoTIFF ImageWriter found. Ensure ImageIO-Ext is on classpath.");
                return;
            }
            ImageWriter imageWriter = writers.next();

            // Create an ImageOutputStream to write to the file
            outputStream = ImageIO.createImageOutputStream(outputFile);
            imageWriter.setOutput(outputStream);

            // 5. Write the GeoTIFF
            // The GeoTiffFormat's writer will handle embedding the georeferencing
            // information from the GridCoverage2D into the TIFF file.
            writer = format.getWriter(outputFile);
            writer.write(coverage, null); // The second argument is for hints, null is fine for basic write

            System.out.println("GeoTIFF created successfully at: " + outputFile.getAbsolutePath());

        } catch (IOException e) {
            System.err.println("Error writing GeoTIFF: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Close the writer and output stream
            if (writer != null) {
                try {
                    writer.dispose();
                } catch (IOException e) {
                    System.err.println("Error disposing writer: " + e.getMessage());
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    System.err.println("Error closing output stream: " + e.getMessage());
                }
            }
        }
    }
}
