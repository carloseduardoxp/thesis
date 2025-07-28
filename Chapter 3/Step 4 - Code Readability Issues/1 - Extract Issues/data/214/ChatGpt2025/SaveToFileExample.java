import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SaveToFileExample {
    public static void main(String[] args) {
        String data = "This is the data to save into the file.";
        String filePath = "output.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(data);
            System.out.println("Data saved to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
