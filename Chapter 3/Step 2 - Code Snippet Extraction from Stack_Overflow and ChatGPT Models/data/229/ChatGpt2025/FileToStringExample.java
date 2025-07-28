import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileToStringExample {
    public static String readFileAsString(String filePath) throws IOException {
        return Files.readString(Path.of(filePath));
    }

    public static void main(String[] args) {
        try {
            String content = readFileAsString("example.txt");
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
