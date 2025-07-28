import java.io.*;

public class DeepSeek {

    public static void main(String[] args) {
        InputStream inputStream = DeepSeek.class.getClassLoader().getResourceAsStream("path/to/file.txt");

        if (inputStream != null) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.err.println("Error reading file: " + e.getMessage());
            }
        } else {
            System.err.println("File not found in classpath");
        }
    }
}
