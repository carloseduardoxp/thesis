import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadHtmlToString {
    public static void main(String[] args) {
        String filePath = "path/to/your/file.html";
        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n"); // Or just append if you don't need line breaks
            }
            String htmlContent = content.toString();
            System.out.println(htmlContent);
            // Now you can work with the htmlContent String
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
