import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class WriteTextToFile {
    public static void main(String[] args) {
        String data = "Hello, this is a test string.\n";
        data += "This will be written to a file.\n";
        String filePath = "myTextFile.txt"; // You can provide a full path like "C:/data/myTextFile.txt"

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(data);
            System.out.println("Data successfully written to " + filePath);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
