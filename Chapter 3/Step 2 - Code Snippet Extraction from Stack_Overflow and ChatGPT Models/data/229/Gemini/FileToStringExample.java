import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;

public class FileToStringExample {

    public static String readFileToString(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        return Files.readString(path, StandardCharsets.UTF_8);
    }

    public static void main(String[] args) {
        String fileName = "myFile.txt"; // Replace with your file name/path

        try {
            // Create a dummy file for demonstration
            Files.writeString(Paths.get(fileName), "Hello from the file!\nThis is line two.", StandardCharsets.UTF_8);

            String fileContent = readFileToString(fileName);
            System.out.println("File content:\n" + fileContent);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
