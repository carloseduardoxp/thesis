import java.net.HttpURLConnection;
import java.net.URL;
import java.io.IOException;

public class HttpHeaderExample {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://example.com/api");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        
        // Set request method
        connection.setRequestMethod("GET");
        
        // Set headers
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Authorization", "Bearer your_token_here");
        connection.setRequestProperty("User-Agent", "MyJavaApp/1.0");
        
        // Get response code
        int responseCode = connection.getResponseCode();
        System.out.println("Response Code: " + responseCode);
        
        // Remember to close the connection
        connection.disconnect();
    }
}
