import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class HttpPostExample {

    /**
     * Custom exception for failures during the HTTP POST request process.
     */
    public static class HttpPostRequestException extends Exception {
        public HttpPostRequestException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static void main(String[] args) {
        String urlString = "https://api.example.com/data"; // Replace with your target URL
        String jsonPayload = "{\"name\": \"John Doe\", \"age\": 30}"; // Replace with your JSON payload

        try {
            sendPostRequest(urlString, jsonPayload);
        } catch (HttpPostRequestException e) {
            System.err.println("Error during HTTP POST request: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void sendPostRequest(String urlString, String jsonPayload) throws HttpPostRequestException {
        HttpURLConnection connection = null;
        try {
            URL url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();

            // Set up the connection for POST
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json"); // Often "application/json" or "application/x-www-form-urlencoded"
            connection.setRequestProperty("Accept", "application/json"); // What the client accepts back
            connection.setDoOutput(true); // Allows writing to the output stream

            // Send the payload
            try (DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
                byte[] postData = jsonPayload.getBytes(StandardCharsets.UTF_8);
                wr.write(postData);
            }

            // Get the response code
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // Read the response
            try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                System.out.println("Response Body: " + response.toString());
            }
        } catch (Exception e) {
            // Wrap and throw a dedicated exception instead of a generic one
            throw new HttpPostRequestException("Failed to send POST request to " + urlString, e);
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}
