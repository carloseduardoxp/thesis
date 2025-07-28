import java.io.File;
import java.io.IOException;
import org.geotools.data.FileDataStore;
import org.geotools.data.FileDataStoreFinder;
import org.geotools.data.simple.SimpleFeatureSource;
import org.geotools.map.DefaultMapLayer;
import org.geotools.map.MapContent;
import org.geotools.styling.SLD;
import org.geotools.styling.Style;
import org.geotools.swing.JMapFrame;

public class ShapefileDisplayExample {
   public static void main(String[] args) throws IOException {
      // Open the shapefile
      File file = new File("example.shp");
      FileDataStore store = FileDataStoreFinder.getDataStore(file);
      SimpleFeatureSource featureSource = store.getFeatureSource();

      // Create a map content and add the shapefile layer
      MapContent mapContent = new MapContent();
      DefaultMapLayer layer = new DefaultMapLayer(featureSource, createStyle());
      mapContent.addLayer(layer);

      // Display the map in a frame
      JMapFrame frame = new JMapFrame(mapContent);
      frame.setSize(800, 600);
      frame.setVisible(true);
   }

   private static Style createStyle() {
      // Create a default style for the shapefile
      return SLD.createSimpleStyle(featureSource.getSchema());
   }
}
