import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ResourceReader {
    public static void main(String[] args) {
        // Get the input stream for a resource file
        InputStream inputStream = ResourceReader.class.getResourceAsStream("/path/to/resource/file");

        // Read the contents of the file
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            // Handle exceptions
        }
    }
}
