import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class HttpPostExample {

    public static void main(String[] args) {
        String urlString = "https://api.example.com/data"; // Replace with your target URL
        String jsonPayload = "{\"name\": \"John Doe\", \"age\": 30}"; // Replace with your JSON payload

        try {
            sendPostRequest(urlString, jsonPayload);
        } catch (HttpRequestException e) {
            e.printStackTrace();
        }
    }

    public static void sendPostRequest(String urlString, String jsonPayload) throws HttpRequestException {
        URL url;
        HttpURLConnection connection = null;

        try {
            url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();

            // Set up the connection for POST
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);

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
            throw new HttpRequestException("Failed to send HTTP POST request", e);
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}

class HttpRequestException extends Exception {
    public HttpRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}