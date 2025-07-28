import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class FileToUrlConverter {

    public static void main(String[] args) {
        // Example file path (can be absolute or relative)
        String filePathString = "my_document with spaces.txt";
        // Create a File object
        File file = new File(filePathString);

        // For demonstration, let's create the file if it doesn't exist
        try {
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("Created file: " + file.getAbsolutePath());
            }
        } catch (Exception e) {
            System.err.println("Error creating file: " + e.getMessage());
        }

        try {
            // Step 1: Convert File to URI
            URI uri = file.toURI();
            System.out.println("URI: " + uri);

            // Step 2: Convert URI to URL
            URL url = uri.toURL();
            System.out.println("URL: " + url);

            // You can also chain them:
            URL directUrl = new File(filePathString).toURI().toURL();
            System.out.println("Direct URL conversion: " + directUrl);

        } catch (MalformedURLException e) {
            System.err.println("Malformed URL Exception: " + e.getMessage());
        }
    }
}
