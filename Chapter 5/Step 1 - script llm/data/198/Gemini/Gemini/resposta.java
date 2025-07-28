import java.io.File;
import java.io.IOException;

public class TempFileCreator {

    public static void main(String[] args) {
        File tempFile = null;
        try {
            // Create a temporary file with a specified prefix and suffix.
            // The file will be created in the default temporary-file directory.
            // The prefix must be at least three characters long.
            // The suffix can be null, in which case ".tmp" will be used.
            tempFile = File.createTempFile("myAppTemp", ".tmp");

            System.out.println("Temporary file created: " + tempFile.getAbsolutePath());

            // You can now write to this file, read from it, etc.
            // For example, to write some content:

            // To ensure the file is deleted when the JVM exits, you can use deleteOnExit().
            // This is particularly useful for temporary files that don't need to persist.
            tempFile.deleteOnExit();
            System.out.println("Temporary file marked for deletion on JVM exit.");

        } catch (IOException e) {
            System.err.println("An error occurred while creating the temporary file: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Optional: If you want to explicitly delete the file when you are done with it,
            // regardless of JVM exit, you can do it here or at another appropriate point.
            // Be careful with this if other parts of your application might still need the file.
        }
    }
}
