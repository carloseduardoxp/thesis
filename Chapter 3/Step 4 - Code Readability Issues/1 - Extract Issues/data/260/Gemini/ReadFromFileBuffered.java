import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFromFileBuffered {
    public static void main(String[] args) {
        String filePath = "myTextFile.txt"; // Make sure this file exists in the same directory as your Java code or provide a full path

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
