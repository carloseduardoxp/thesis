import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import org.geotools.coverage.grid.GridCoverage2D;
import org.geotools.coverage.grid.io.GridCoverage2DWriter;
import org.geotools.coverage.grid.io.imageio.GeoTiffWriter;
import org.geotools.gce.geotiff.GeoTiffFormat;
import java.awt.Rectangle;
import java.awt.image.RenderedImage;
import org.geotools.coverage.grid.GridCoverage2D;
import org.geotools.coverage.grid.GridCoverageFactory;
import org.geotools.coverage.grid.io.AbstractGridFormat;

public class GeoTiffCreator {

    public static void main(String[] args) throws Exception {
        // Load the raster image
        File imageFile = new File("input.png");
        BufferedImage image = ImageIO.read(imageFile);

        // Create a GridCoverage2D from the image
        GridCoverage2D coverage = createCoverage(image);

        // Create a GeoTiffWriter to write the GeoTIFF file
        File outputFile = new File("output.tif");
        GeoTiffWriter writer = new GeoTiffWriter(outputFile);

        // Write the GridCoverage2D to the GeoTIFF file
        writer.write(coverage, null);

        // Close the writer
        writer.dispose();
    }

    private static GridCoverage2D createCoverage(BufferedImage image) {
        // Create a RenderedImage from the BufferedImage
        RenderedImage renderedImage = image;

        // Create a GridCoverageFactory to create the GridCoverage2D
        GridCoverageFactory factory = new GridCoverageFactory();

        // Create a Rectangle to define the spatial extent of the image
        Rectangle bounds = new Rectangle(0, 0, image.getWidth(), image.getHeight());

        // Return the GridCoverage2D
        return factory.create("Image", renderedImage, bounds);
    }
}
