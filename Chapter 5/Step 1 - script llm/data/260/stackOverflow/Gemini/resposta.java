import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Teste {

    // This method was missing in the original snippet and is added for completeness.
    private static InputStream openFileInput(String path) throws IOException {
        return new FileInputStream(path);
    }

    public static void main(String[] args) {
        try (InputStream instream = openFileInput("E:\\test\\src\\com\\test\\mani.txt");
             BufferedReader buffreader = new BufferedReader(new InputStreamReader(instream, StandardCharsets.UTF_8))) {

            // Read all lines from the file; the original code stored them in a variable
            // that was never used, so here we just read and discard them.
            while (buffreader.readLine() != null) {
                // Intentional no-op
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
