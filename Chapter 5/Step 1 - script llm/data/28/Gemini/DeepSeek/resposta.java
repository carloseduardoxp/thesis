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

        for (File file : files) {
            if (file.isFile()) {
                processFile(file, searchPattern, useRegex);
            }
        }
    }

    private static void processFile(File file, String searchPattern, boolean useRegex) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int lineNumber = 1;
            while ((line = reader.readLine()) != null) {
                if (matchesPattern(line, searchPattern, useRegex)) {
                    System.out.println("Found in file: " + file.getName() + ", line " + lineNumber + ": " + line);
                }
                lineNumber++;
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + file.getName() + " - " + e.getMessage());
        }
    }

    private static boolean matchesPattern(String line, String searchPattern, boolean useRegex) {
        if (useRegex) {
            Pattern pattern = Pattern.compile(searchPattern);
            Matcher matcher = pattern.matcher(line);
            return matcher.find();
        } else {
            return line.contains(searchPattern);
        }
    }

    public static void main(String[] args) {
        String folderPath = "/path/to/your/folder";
        String searchText = "your_pattern";
        boolean useRegularExpression = false;

        findPattern(folderPath, searchText, useRegularExpression);

        String regexPattern = "\\d+";
        boolean useRegex = true;
        System.out.println("\nSearching with regular expression: " + regexPattern);
        findPattern(folderPath, regexPattern, useRegex);
    }
}
