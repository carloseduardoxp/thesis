import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TextFileCreator {
    public static void main(String[] args) {
        try {
            // Create a File object for the new text file
            File file = new File("newfile.txt");

            // Create a FileWriter object to write to the new text file
            FileWriter writer = new FileWriter(file);

            // Write some text to the file
            writer.write("Hello, world!");

            // Close the FileWriter to free up resources
            writer.close();

            System.out.println("File created: " + file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
