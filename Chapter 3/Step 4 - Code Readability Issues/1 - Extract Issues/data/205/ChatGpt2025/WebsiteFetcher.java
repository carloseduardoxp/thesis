import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebsiteFetcher {
    public static void main(String[] args) {
        try {
            // Replace with the website URL you want to fetch
            URL url = new URL("https://example.com");

            // Open a connection to the website
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set request method to GET
            connection.setRequestMethod("GET");

            // Read the response
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;

            System.out.println("Website content:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Close the reader
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
