import java.io.*;

public class FileReadWriteExample {
    public static void main(String[] args) {
        String inputFile = "input.txt";   // file to read from
        String outputFile = "output.txt"; // file to write to

        try (
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                // process the line if needed
                System.out.println("Read line: " + line);

                // write line to output file
                writer.write(line);
                writer.newLine(); // add a newline after each line
            }
            System.out.println("File read and write completed.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
