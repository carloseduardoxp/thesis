import java.io.*;
import java.util.*;

public class FileSorter {
    public static void main(String[] args) throws IOException {
        // Read file contents into a list
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }

        // Sort the list
        Collections.sort(lines);

        // Write the sorted contents back to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        }
    }
}
