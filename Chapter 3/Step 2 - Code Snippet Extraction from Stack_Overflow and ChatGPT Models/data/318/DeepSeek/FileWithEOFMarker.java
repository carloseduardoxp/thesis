import java.io.FileWriter;
import java.io.IOException;

public class FileWithEOFMarker {
    public static void main(String[] args) {
        try (FileWriter writer = new FileWriter("example.txt")) {
            writer.write("This is some file content\n");
            // Writing ASCII SUB character (Ctrl-Z, sometimes used as EOF marker in Windows)
            writer.write(26); 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
