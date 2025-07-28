import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RecursiveDirectoryCreator {

    public static void main(String[] args) {
        // Define the path (use double backslashes for Windows, or slashes for Unix/Mac)
        String directoryPath = "parentDir/subDir1/subDir2";

        // Convert to Path object
        Path path = Paths.get(directoryPath);

        try {
            // Create directories recursively
            Files.createDirectories(path);
            System.out.println("Directories created successfully: " + path.toAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error creating directories: " + e.getMessage());
        }
    }
}
