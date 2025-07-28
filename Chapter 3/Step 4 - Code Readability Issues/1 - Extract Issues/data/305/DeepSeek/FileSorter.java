import java.io.*;
import java.util.*;

public class FileSorter {
    public static void sortTextFile(String inputFile, String outputFile) throws IOException {
        // Read all lines from the file
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        List<String> lines = new ArrayList<>();
        
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        reader.close();
        
        // Sort the lines
        Collections.sort(lines);
        
        // Write the sorted lines back to a file
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
        for (String sortedLine : lines) {
            writer.write(sortedLine);
            writer.newLine();
        }
        writer.close();
    }
    
    public static void main(String[] args) {
        try {
            sortTextFile("input.txt", "output_sorted.txt");
            System.out.println("File sorted successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
