import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Chat {
    public static void main(String[] args) {
        String fileName = "output.txt";
        String content = "Hello, this is a line written to a text file in Java.";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content);
            writer.newLine(); // adds a new line
            writer.write("This is another line.");
            System.out.println("File written successfully!");
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
