import java.io.*;
import java.util.*;

public class Teste {

    public static void main(String[] args) {        
        File file = new File("mayshapefile.shp");

        try {
            Map<String, String> connect = new HashMap<String, String>();
            connect.put("url", file.toURI().toString());

            DataStore dataStore = DataStoreFinder.getDataStore(connect);
            String[] typeNames = dataStore.getTypeNames();
            String typeName = typeNames[0];

            System.out.println("Reading content " + typeName);

            FeatureSource featureSource = dataStore.getFeatureSource(typeName);
            FeatureCollection collection = featureSource.getFeatures();
            FeatureIterator iterator = collection.features();

            try {
                while (iterator.hasNext()) {
                    Feature feature = iterator.next();
                    // Removed unused variable 'sourceGeometry'
                }
            } finally {
                iterator.close();
            }

        } catch (Throwable e) {
            // Removed empty catch block
        }
    }
}
