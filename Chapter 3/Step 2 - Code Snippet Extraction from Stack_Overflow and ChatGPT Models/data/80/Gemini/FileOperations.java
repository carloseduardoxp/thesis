import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileOperations {

    private static final String INPUT_FILE_NAME = "input.txt";
    private static final String OUTPUT_FILE_NAME = "output.txt";

    public static void main(String[] args) {
        // Ensure the input file exists and has some content for demonstration
        createAndPopulateInputFile();

        System.out.println("Attempting to read from '" + INPUT_FILE_NAME + "' and write to '" + OUTPUT_FILE_NAME + "'...");

        try {
            // Step 1: Read from the input file
            // Using try-with-resources to ensure that the FileReader and BufferedReader are closed automatically
            try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILE_NAME))) {
                // Step 2: Write to the output file
                // Using try-with-resources to ensure that the FileWriter and BufferedWriter are closed automatically
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME))) {
                    String line;
                    // Read each line from the input file until the end of the file is reached
                    while ((line = reader.readLine()) != null) {
                        // Print the line being read (optional, for demonstration)
                        System.out.println("Reading: " + line);
                        // Write the read line to the output file
                        writer.write(line);
                        // Add a new line character after each line to maintain formatting in the output file
                        writer.newLine();
                    }
                    System.out.println("\nSuccessfully read from '" + INPUT_FILE_NAME + "' and wrote to '" + OUTPUT_FILE_NAME + "'.");
                }
            }
        } catch (IOException e) {
            // Catch any IOException that might occur during file operations
            System.err.println("An error occurred during file operations: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Helper method to create an input.txt file with some sample content
     * if it doesn't already exist.
     */
    private static void createAndPopulateInputFile() {
        Path inputFilePath = Paths.get(INPUT_FILE_NAME);
        if (!Files.exists(inputFilePath)) {
            System.out.println("Creating '" + INPUT_FILE_NAME + "' with sample content...");
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(INPUT_FILE_NAME))) {
                writer.write("This is the first line of sample text.");
                writer.newLine();
                writer.write("This is the second line.");
                writer.newLine();
                writer.write("And this is the final line for demonstration.");
                writer.newLine();
                System.out.println("'" + INPUT_FILE_NAME + "' created successfully.");
            } catch (IOException e) {
                System.err.println("Error creating input file: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.out.println("'" + INPUT_FILE_NAME + "' already exists. Using existing content.");
        }
    }
}
