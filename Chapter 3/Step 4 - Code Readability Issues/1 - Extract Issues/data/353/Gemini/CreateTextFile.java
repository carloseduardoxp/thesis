import java.io.FileWriter;
import java.io.IOException;

public class CreateTextFile {

    public static void main(String[] args) {
        String fileName = "myFile.txt"; // Name of the file to create
        String content = "Hello, this is some text written to the file."; // Content to write

        try {
            // Create a FileWriter object.
            // The 'true' argument in FileWriter(fileName, true) means append to the file
            // If you want to overwrite the file, remove the 'true' argument or set it to 'false'
            FileWriter writer = new FileWriter(fileName);

            // Write the content to the file
            writer.write(content);

            // Close the writer to ensure all data is flushed and resources are released
            writer.close();

            System.out.println("File '" + fileName + "' created successfully!");

        } catch (IOException e) {
            // Catch any IOException that might occur during file operations
            System.err.println("An error occurred while creating the file: " + e.getMessage());
            e.printStackTrace(); // Print the stack trace for debugging
        }
    }
}
