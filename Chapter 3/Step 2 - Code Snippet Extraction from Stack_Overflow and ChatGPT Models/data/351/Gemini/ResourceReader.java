import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class ResourceReader {

    public static void main(String[] args) {
        readResourceFile("config.properties");
        readResourceFile("data/example.txt"); // For a file in a subdirectory
    }

    public static void readResourceFile(String resourceName) {
        // Use the current class's ClassLoader to find the resource
        // The resource name should be relative to the root of the classpath
        // No leading slash is needed if the resource is at the root of src/main/resources
        // If it's in a subdirectory (e.g., src/main/resources/data/example.txt),
        // the path should be "data/example.txt"
        try (InputStream inputStream = ResourceReader.class.getClassLoader().getResourceAsStream(resourceName)) {
            if (inputStream == null) {
                System.err.println("Resource not found: " + resourceName);
                return;
            }

            // Read the content of the resource
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
                String line;
                System.out.println("Content of " + resourceName + ":");
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading resource: " + resourceName + " - " + e.getMessage());
        }
    }
}
