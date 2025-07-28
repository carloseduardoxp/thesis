import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileSorter {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "sorted_output.txt";

        try {
            // Read all lines from the file into a List
            List<String> lines = Files.readAllLines(Paths.get(inputFile));

            // Sort the lines alphabetically
            Collections.sort(lines);

            // Write the sorted lines to the output file
            Files.write(Paths.get(outputFile), lines);

            System.out.println("File sorted successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
