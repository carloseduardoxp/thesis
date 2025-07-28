import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String data = "Hello, World!";

        try {
            // Create a File object for the file you want to save
            File file = new File("output.txt");

            // Create a FileWriter object to write to the file
            FileWriter fileWriter = new FileWriter(file);

            // Create a BufferedWriter object to write the data to the file
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Write the data to the file
            bufferedWriter.write(data);

            // Close the BufferedWriter
            bufferedWriter.close();

            System.out.println("Data saved to file.");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
