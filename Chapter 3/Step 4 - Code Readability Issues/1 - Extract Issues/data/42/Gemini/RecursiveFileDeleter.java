import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class RecursiveFileDeleter {

    public static void deleteRecursively(File directory) throws IOException {
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException("Path must be a directory: " + directory);
        }

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    deleteRecursively(file); // Recursive call for subdirectories
                } else {
                    Files.delete(file.toPath());
                    System.out.println("Deleted file: " + file.getAbsolutePath());
                }
            }
        }

        // Finally, delete the empty directory itself
        Files.delete(directory.toPath());
        System.out.println("Deleted directory: " + directory.getAbsolutePath());
    }

    public static void main(String[] args) {
        String directoryToDelete = "/path/to/your/directory"; // Replace with the actual path

        File directory = new File(directoryToDelete);

        try {
            deleteRecursively(directory);
            System.out.println("Deletion process completed.");
        } catch (IOException e) {
            System.err.println("Error during deletion: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid argument: " + e.getMessage());
        }
    }
}
