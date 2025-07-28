import org.geotools.data.FileDataStore;
import org.geotools.data.FileDataStoreFinder;
import org.geotools.data.simple.SimpleFeatureSource;
import org.geotools.map.FeatureLayer;
import org.geotools.map.MapContent;
import org.geotools.renderer.lite.StreamingRenderer;
import org.geotools.swing.JMapFrame;
import org.geotools.styling.SLD;
import org.geotools.styling.Style;

import java.io.File;

public class ShapefileViewer {
    public static void main(String[] args) throws Exception {
        // Path to your shapefile
        File file = new File("path/to/your/shapefile.shp");

        // Load the shapefile
        FileDataStore store = FileDataStoreFinder.getDataStore(file);
        SimpleFeatureSource featureSource = store.getFeatureSource();

        // Create a map content and add the shapefile layer
        MapContent map = new MapContent();
        map.setTitle("Shapefile Display");

        // Create a default style to draw features
        Style style = SLD.createSimpleStyle(featureSource.getSchema());

        // Add the layer to the map content
        FeatureLayer layer = new FeatureLayer(featureSource, style);
        map.addLayer(layer);

        // Display the map in a JFrame
        JMapFrame.showMap(map);
    }
}
