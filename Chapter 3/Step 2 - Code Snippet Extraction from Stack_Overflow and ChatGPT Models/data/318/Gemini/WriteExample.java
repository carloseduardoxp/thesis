import java.io.FileWriter;
import java.io.IOException;

public class WriteExample {
    public static void main(String[] args) {
        String fileName = "myFile.txt";
        String content = "This is some content for the file.";

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(content);
            // When the try-with-resources block exits, writer.close() is automatically called,
            // which flushes the content and effectively "marks" the end of the file.
            System.out.println("Content written to " + fileName + " successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
