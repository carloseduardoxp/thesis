import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortFileLines {

    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output_sorted.txt";

        try {
            // 1. Read all lines from the input file
            List<String> lines = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    lines.add(line);
                }
            }

            // 2. Sort the lines
            Collections.sort(lines); // Sorts alphabetically (natural order for Strings)

            // 3. Write the sorted lines to the output file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
                for (String line : lines) {
                    writer.write(line);
                    writer.newLine(); // Add a new line character after each line
                }
            }

            System.out.println("File sorted successfully. Sorted content written to " + outputFile);

        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
