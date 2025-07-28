import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpURLConnectionExample {

    public static void main(String[] args) {
        try {
            // 1. Create a URL object
            URL url = new URL("https://jsonplaceholder.typicode.com/todos/1"); // Example URL

            // 2. Open a connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // 3. Set the request method (GET, POST, etc.)
            connection.setRequestMethod("GET");

            // Optional: Set request headers
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("User-Agent", "MyAwesomeApp/1.0");

            // 4. Get the response code
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // 5. Get the response body
            if (responseCode >= 200 && responseCode < 300) { // Check for success
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                System.out.println("Response Body:\n" + response.toString());
            } else {
                System.out.println("Error: " + responseCode);
                // Optionally, read the error stream:  connection.getErrorStream()
            }

            // 6. Disconnect
            connection.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
