import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class LoadFileFromClasspathExample {
    public static void main(String[] args) {
        String filename = "resources/myFile.txt";
        ClassLoader classLoader = LoadFileFromClasspathExample.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(filename);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
