import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Teste {

    public static void main(String[] args) {
        File file = new File("mayshapefile.shp");

        try {
            Map<String, String> connect = new HashMap<>();
            connect.put("url", file.toURI().toString());

            DataStore dataStore = DataStoreFinder.getDataStore(connect);
            String[] typeNames = dataStore.getTypeNames();
            String typeName = typeNames[0];

            System.out.println("Reading content " + typeName);

            FeatureSource featureSource = dataStore.getFeatureSource(typeName);
            FeatureCollection collection = featureSource.getFeatures();

            try (FeatureIterator iterator = collection.features()) {
                while (iterator.hasNext()) {
                    iterator.next();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
