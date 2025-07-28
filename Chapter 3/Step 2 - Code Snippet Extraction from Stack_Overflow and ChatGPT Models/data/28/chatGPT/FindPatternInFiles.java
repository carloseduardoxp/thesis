import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindPatternInFiles {
    public static void main(String[] args) throws IOException {
        // Define the folder path and pattern to search
        String folderPath = "/path/to/folder";
        String patternString = "your_pattern_here";
        Pattern pattern = Pattern.compile(patternString);

        // Get a list of all files in the folder
        File folder = new File(folderPath);
        File[] files = folder.listFiles();

        // Loop through each file and search for the pattern
        for (File file : files) {
            if (file.isFile()) {
                Path filePath = file.toPath();
                String fileContent = Files.readString(filePath);

                // Search for the pattern in the file content
                Matcher matcher = pattern.matcher(fileContent);
                while (matcher.find()) {
                    System.out.printf("Pattern found in file %s at position %d%n", file.getName(), matcher.start());
                }
            }
        }
    }
}
