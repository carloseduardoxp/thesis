import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TempFileExample {
    public static void main(String[] args) {
        try {
            Path tempFile = Files.createTempFile("temp", ".txt");
            File file = tempFile.toFile();
            System.out.println("Temporary file created: " + file.getAbsolutePath());
            file.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
