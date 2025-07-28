import java.io.IOException;
import java.nio.file.*;

public class Chat {
    public static void main(String[] args) {
        try {
            Path path = Paths.get("example.txt");
            Files.delete(path);
            System.out.println("File deleted successfully");
        } catch (NoSuchFileException e) {
            System.out.println("No such file exists");
        } catch (DirectoryNotEmptyException e) {
            System.out.println("Directory is not empty");
        } catch (IOException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}
