import org.geotools.data.FileDataStore;
import org.geotools.data.FileDataStoreFinder;
import org.geotools.data.simple.SimpleFeatureSource;
import org.geotools.map.FeatureLayer;
import org.geotools.map.MapContent;
import org.geotools.swing.JMapFrame;
import org.geotools.swing.data.JFileDataStoreChooser;
import org.opengis.feature.simple.SimpleFeatureType;

import java.io.File;
import java.io.IOException;

public class ShapefileViewer {

    public static void main(String[] args) {
        try {
            // 1. Choose the shapefile
            File file = JFileDataStoreChooser.showOpenFile("shp", null);
            if (file == null) {
                return; // User cancelled
            }

            // 2. Create a DataStore from the shapefile
            FileDataStore store = FileDataStoreFinder.getDataStore(file);
            if (store == null) {
                System.err.println("Could not create data store for: " + file.getAbsolutePath());
                return;
            }

            // 3. Get the feature source
            SimpleFeatureSource featureSource = store.getFeatureSource();
            SimpleFeatureType schema = featureSource.getSchema();
            System.out.println("Shapefile schema: " + schema);

            // 4. Create a MapContent
            MapContent map = new MapContent();
            map.setTitle("Shapefile Viewer");

            // 5. Create a FeatureLayer and add it to the map
            // You can optionally define a custom style here. For simplicity, we'll use a default.
            FeatureLayer layer = new FeatureLayer(featureSource, null); // null for default style
            map.addLayer(layer);

            // 6. Display the map in a JMapFrame
            JMapFrame.showMap(map);

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error reading or displaying shapefile: " + e.getMessage());
        }
    }
}
