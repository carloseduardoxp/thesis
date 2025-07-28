import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class FindPatternInFiles {

    public static void findPattern(String folderPath, String searchPattern, boolean useRegex) {
        File folder = new File(folderPath);
        File[] files = folder.listFiles();

        if (files == null) {
            System.err.println("Could not list files in folder: " + folderPath);
            return;
        }

        Predicate<String> lineMatcher = createLineMatcher(searchPattern, useRegex);

        for (File file : files) {
            if (file.isFile()) {
                findPatternInFile(file, lineMatcher);
            }
        }
    }

    private static Predicate<String> createLineMatcher(String searchPattern, boolean useRegex) {
        if (useRegex) {
            Pattern pattern = Pattern.compile(searchPattern);
            return line -> pattern.matcher(line).find();
        } else {
            return line -> line.contains(searchPattern);
        }
    }

    private static void findPatternInFile(File file, Predicate<String> lineMatcher) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int lineNumber = 1;
            while ((line = reader.readLine()) != null) {
                if (lineMatcher.test(line)) {
                    System.out.println("Found in file: " + file.getName() + ", line " + lineNumber + ": " + line);
                }
                lineNumber++;
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + file.getName() + " - " + e.getMessage());
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
