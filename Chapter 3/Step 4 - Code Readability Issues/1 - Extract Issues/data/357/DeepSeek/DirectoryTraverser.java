import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirectoryTraverser {
    public static void main(String[] args) throws IOException {
        Path startPath = Paths.get("/path/to/directory");
        
        Files.walk(startPath)
            .forEach(path -> {
                System.out.println(path);
                // Add your file processing logic here
            });
    }
}
