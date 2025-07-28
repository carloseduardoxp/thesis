import java.io.FileWriter;
import java.io.IOException;

public class Gemini {
    public static void main(String[] args) {
        String filename = "output.txt";
        String content = "Hello, this is some text to write to the file.\nThis is another line.";

        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(content);
            System.out.println("Successfully wrote to the file: " + filename);
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}
