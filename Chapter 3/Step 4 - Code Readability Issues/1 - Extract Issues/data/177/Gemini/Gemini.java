import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class HttpRequestHeaders {

    public static void main(String[] args) {
        try {
            // 1. Define the URL
            URL url = new URL("https://api.example.com/data"); // Replace with your actual URL

            // 2. Open a connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // 3. Set the request method (e.g., GET, POST, PUT, DELETE)
            connection.setRequestMethod("GET");

            // 4. Set request headers
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Authorization", "Bearer your_access_token_here");
            connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8"); // For POST/PUT requests with a body

            // 5. Configure connection properties (optional)
            connection.setConnectTimeout(5000); // 5 seconds
            connection.setReadTimeout(5000);    // 5 seconds
            connection.setDoOutput(true);       // Required for POST/PUT requests to write a body

            // 6. If you're sending a POST/PUT request with a body
            String jsonInputString = "{\"name\": \"John Doe\", \"age\": 30}";
            if (connection.getRequestMethod().equals("POST") || connection.getRequestMethod().equals("PUT")) {
                try (OutputStream os = connection.getOutputStream()) {
                    byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
                    os.write(input, 0, input.length);
                }
            }

            // 7. Get the response code
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // 8. Read the response
            if (responseCode == HttpURLConnection.HTTP_OK) { // 200
                try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    String inputLine;
                    StringBuilder response = new StringBuilder();
                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    System.out.println("Response Body: " + response.toString());
                }
            } else {
                // Handle error responses
                try (BufferedReader err = new BufferedReader(new InputStreamReader(connection.getErrorStream()))) {
                    String errorLine;
                    StringBuilder errorResponse = new StringBuilder();
                    while ((errorLine = err.readLine()) != null) {
                        errorResponse.append(errorLine);
                    }
                    System.err.println("Error Response: " + errorResponse.toString());
                }
            }

            // 9. Close the connection
            connection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
