import java.io.File;
import java.io.IOException;

public class TempFileCreator {

    public static void main(String[] args) {
        File tempFile = null;
        try {
            tempFile = File.createTempFile("myAppTemp", ".tmp");

            System.out.println("Temporary file created: " + tempFile.getAbsolutePath());

            tempFile.deleteOnExit();
            System.out.println("Temporary file marked for deletion on JVM exit.");

        } catch (IOException e) {
            System.err.println("An error occurred while creating the temporary file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
