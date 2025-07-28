import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class ReadFileToString {
    public static String readFileAsString(String fileName) throws IOException {
        return Files.readString(Paths.get(fileName));
    }
}
