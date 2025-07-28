import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class HttpPostExample {
    public static void main(String[] args) {
        try {
            // URL to which the POST request will be sent
            URL url = new URL("https://example.com/api");

            // Open connection
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // Set request method to POST
            conn.setRequestMethod("POST");

            // Set headers (optional)
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setRequestProperty("Accept", "application/json");

            // Enable writing output to the connection
            conn.setDoOutput(true);

            // JSON payload to send in the POST request
            String jsonInputString = "{\"name\": \"John\", \"age\": 30}";

            // Write JSON input to the output stream
            try(OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            // Optional: read response code
            int code = conn.getResponseCode();
            System.out.println("Response Code: " + code);

            // You can also read response body here if needed

            conn.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}