import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Teste {

    public static void main(String[] args) throws IOException {
        try (BufferedReader r = new BufferedReader(new FileReader("myFile.txt"))) {
            while (r.readLine() != null) {
                // The original code's logic for processing the line would go here.
            }
        }
    }
}
