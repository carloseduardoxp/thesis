import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CreateDirectories {
    public static void main(String[] args) {
        // Path to create (can be absolute or relative)
        Path path = Paths.get("parent/child/grandchild");
        
        try {
            // Creates all nonexistent parent directories first
            Files.createDirectories(path);
            System.out.println("Directory structure created successfully");
        } catch (Exception e) {
            System.err.println("Failed to create directory structure: " + e.getMessage());
        }
    }
}
