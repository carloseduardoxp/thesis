import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternFinder {
    public static void main(String[] args) {
        String folderPath = "C:/example/folder"; // Change this to your folder path
        String regex = "\\bhello\\b"; // Example pattern: exact word "hello"
        Pattern pattern = Pattern.compile(regex);

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(folderPath))) {
            for (Path filePath : stream) {
                if (Files.isRegularFile(filePath)) {
                    searchFile(filePath, pattern);
                }
            }
        } catch (IOException e) {
            System.err.println("Error accessing directory: " + e.getMessage());
        }
    }

    private static void searchFile(Path filePath, Pattern pattern) {
        System.out.println("Searching in: " + filePath.getFileName());
        try {
            String content = Files.readString(filePath);
            Matcher matcher = pattern.matcher(content);
            while (matcher.find()) {
                System.out.println("Found: \"" + matcher.group() + "\" at index " + matcher.start());
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + filePath + " - " + e.getMessage());
        }
    }
}
