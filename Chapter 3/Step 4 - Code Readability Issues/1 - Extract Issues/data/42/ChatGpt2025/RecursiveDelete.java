import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class RecursiveDelete {
    public static void deleteRecursively(Path path) throws IOException {
        if (Files.notExists(path)) return;

        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Files.delete(file); // delete file
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                Files.delete(dir); // delete directory after its contents
                return FileVisitResult.CONTINUE;
            }
        });
    }

    public static void main(String[] args) {
        Path directory = Paths.get("path/to/your/folder");

        try {
            deleteRecursively(directory);
            System.out.println("Deleted successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
