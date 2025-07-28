import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirectoryCreator {

    /**
     * Creates a directory, including any necessary but nonexistent parent directories.
     * If the directory already exists, this method does nothing.
     *
     * @param directoryPath The path of the directory to create.
     * @return true if the directory was created or already exists, false otherwise.
     */
    public static boolean createDirectoryRecursive(String directoryPath) {
        // Using java.nio.file.Path for modern file operations
        Path path = Paths.get(directoryPath);

        try {
            // Files.createDirectories creates all nonexistent parent directories first.
            // It does not throw an exception if the directory already exists.
            Files.createDirectories(path);
            System.out.println("Directory created successfully (or already exists): " + path.toAbsolutePath());
            return true;
        } catch (IOException e) {
            System.err.println("Failed to create directory: " + path.toAbsolutePath());
            e.printStackTrace();
            return false;
        }
    }

    /**
     * An alternative method using java.io.File.
     *
     * @param directoryPath The path of the directory to create.
     * @return true if the directory was created or already exists, false otherwise.
     */
    public static boolean createDirectoryRecursiveOldWay(String directoryPath) {
        File directory = new File(directoryPath);

        // mkdirs() creates the directory named by this abstract pathname,
        // including any necessary but nonexistent parent directories.
        // Returns true if the directory was created, along with all necessary parent directories;
        // false otherwise.
        if (directory.exists()) {
            System.out.println("Directory already exists: " + directory.getAbsolutePath());
            return true;
        } else {
            if (directory.mkdirs()) {
                System.out.println("Directory created successfully: " + directory.getAbsolutePath());
                return true;
            } else {
                System.err.println("Failed to create directory: " + directory.getAbsolutePath());
                return false;
            }
        }
    }

    public static void main(String[] args) {
        // Example usage:
        String baseDir = "my_app_data";
        String subDir1 = baseDir + File.separator + "logs";
        String subDir2 = baseDir + File.separator + "cache" + File.separator + "temp";
        String subDir3 = baseDir + File.separator + "config";

        System.out.println("--- Using Files.createDirectories (Recommended) ---");
        createDirectoryRecursive(subDir1);
        createDirectoryRecursive(subDir2);
        createDirectoryRecursive(subDir3);
        createDirectoryRecursive(subDir1); // Trying to create again to show it handles existing directories

        System.out.println("\n--- Using File.mkdirs (Older approach) ---");
        // For demonstration, let's create a new base directory for the old way
        String oldWayBaseDir = "my_old_app_data";
        String oldWaySubDir = oldWayBaseDir + File.separator + "reports" + File.separator + "daily";
        createDirectoryRecursiveOldWay(oldWaySubDir);
        createDirectoryRecursiveOldWay(oldWaySubDir); // Trying to create again to show it handles existing directories
    }
}
