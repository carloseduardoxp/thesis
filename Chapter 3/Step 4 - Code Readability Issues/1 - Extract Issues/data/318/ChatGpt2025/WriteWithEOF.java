import java.io.FileWriter;
import java.io.IOException;

public class WriteWithEOF {
    public static void main(String[] args) {
        try (FileWriter writer = new FileWriter("example.txt")) {
            writer.write("This is some data.\n");
            writer.write("This is more data.\n");
            writer.write("<EOF>"); // Custom EOF marker
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
