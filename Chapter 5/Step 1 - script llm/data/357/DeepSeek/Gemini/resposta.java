import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirectoryTraverser {
    public static void main(String[] args) throws IOException {
        Path startPath = Paths.get("/path/to/directory");
        
        // The comment "Add your file processing logic here" is removed
        // because applying the method reference recommendation replaces the entire lambda body.
        Files.walk(startPath)
            .forEach(System.out::println);
    }
}
