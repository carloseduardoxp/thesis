import java.io.File;
import java.io.IOException;

public class TempFileExample {
    public static void main(String[] args) {
        try {
            // Create a temporary file with default prefix and suffix
            File tempFile = File.createTempFile("temp", ".txt");
            
            System.out.println("Temporary file created at: " + tempFile.getAbsolutePath());
            
            // The file will be automatically deleted when the JVM exits
            tempFile.deleteOnExit();
            
            // Use the temporary file...
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
