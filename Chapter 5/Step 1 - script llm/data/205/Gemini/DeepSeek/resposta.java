import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class GetWebsiteContent {

    public static void main(String[] args) {
        String urlString = "https://www.example.com"; // Replace with your desired URL

        try {
            URL url = new URL(urlString);
            URLConnection connection = url.openConnection();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder content = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                content.append(line);
                content.append(System.lineSeparator()); // Add newline for readability
            }
            reader.close();

            System.out.println("Website content:\n" + content.toString());

        } catch (IOException e) {
            System.err.println("Error fetching website content: " + e.getMessage());
            e.printStackTrace();
        }
    }
}