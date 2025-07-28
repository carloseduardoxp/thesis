import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindPatternInFiles {

    public static void findPattern(String folderPath, String searchPattern, boolean useRegex) {
        File folder = new File(folderPath);
        File[] files = folder.listFiles();

        if (files == null) {
            System.err.println("Could not list files in folder: " + folderPath);
            return;
        }

        Pattern pattern = null;
        if (useRegex) {
            pattern = Pattern.compile(searchPattern);
        }

        for (File file : files) {
            if (file.isFile()) {
                processFile(file, searchPattern, pattern, useRegex);
            }
        }
    }

    private static void processFile(File file, String searchPattern, Pattern pattern, boolean useRegex) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int lineNumber = 1;
            while ((line = reader.readLine()) != null) {
                if (matches(line, searchPattern, pattern, useRegex)) {
                    System.out.println("Found in file: " + file.getName() + ", line " + lineNumber + ": " + line);
                }
                lineNumber++;
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + file.getName() + " - " + e.getMessage());
        }
    }

    private static boolean matches(String line, String searchPattern, Pattern pattern, boolean useRegex) {
        if (useRegex && pattern != null) {
            Matcher matcher = pattern.matcher(line);
            return matcher.find();
        } else {
            return line.contains(searchPattern);
        }
    }

    public static void main(String[] args) {
        String folderPath = "/path/to/your/folder"; // Replace with the actual path to your folder
        String searchText = "your_pattern"; // Replace with the pattern you want to find
        boolean useRegularExpression = false; // Set to true if 'searchText' is a regular expression

        findPattern(folderPath, searchText, useRegularExpression);

        // Example using a regular expression to find lines with one or more digits
        String regexPattern = "\\d+";
        boolean useRegex = true;
        System.out.println("\nSearching with regular expression: " + regexPattern);
        findPattern(folderPath, regexPattern, useRegex);
    }
}
