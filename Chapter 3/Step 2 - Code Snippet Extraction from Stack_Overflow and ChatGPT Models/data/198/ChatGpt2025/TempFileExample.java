import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TempFileExample {
    public static void main(String[] args) {
        try {
            // Create a temporary file with a prefix and suffix
            Path tempFile = Files.createTempFile("myTempFile_", ".txt");

            System.out.println("Temporary file created at: " + tempFile.toAbsolutePath());

            // Optionally delete it on exit
            tempFile.toFile().deleteOnExit();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
