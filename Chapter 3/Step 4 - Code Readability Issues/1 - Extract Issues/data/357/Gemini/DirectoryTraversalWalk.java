import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class DirectoryTraversalWalk {

    public static void main(String[] args) {
        String startDirectory = "/path/to/your/directory"; // Replace with your directory

        try (Stream<Path> walk = Files.walk(Paths.get(startDirectory))) {
            walk.forEach(path -> {
                System.out.println(path);
                // You can add your logic here for each file or directory
                if (Files.isRegularFile(path)) {
                    System.out.println("  File: " + path.getFileName());
                } else if (Files.isDirectory(path)) {
                    System.out.println("  Directory: " + path.getFileName());
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
