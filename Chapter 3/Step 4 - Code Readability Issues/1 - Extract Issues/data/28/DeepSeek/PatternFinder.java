import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class PatternFinder {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java PatternFinder <directory> <pattern>");
            System.exit(1);
        }

        String directoryPath = args[0];
        String patternToFind = args[1];
        
        File directory = new File(directoryPath);
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory: " + directoryPath);
            System.exit(1);
        }

        Pattern pattern = Pattern.compile(patternToFind);
        searchFiles(directory, pattern);
    }

    private static void searchFiles(File directory, Pattern pattern) {
        File[] files = directory.listFiles();
        if (files == null) return;

        for (File file : files) {
            if (file.isDirectory()) {
                // Recursively search subdirectories
                searchFiles(file, pattern);
            } else {
                searchInFile(file, pattern);
            }
        }
    }

    private static void searchInFile(File file, Pattern pattern) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int lineNumber = 0;
            boolean found = false;
            
            while ((line = reader.readLine()) != null) {
                lineNumber++;
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    if (!found) {
                        System.out.println("\nFile: " + file.getAbsolutePath());
                        found = true;
                    }
                    System.out.println("Line " + lineNumber + ": " + line.trim());
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + file.getAbsolutePath());
        }
    }
}
