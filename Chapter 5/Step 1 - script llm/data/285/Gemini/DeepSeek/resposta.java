import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class HttpClientGetRequest {

    public static void main(String[] args) {
        String urlString = "https://jsonplaceholder.typicode.com/posts/1"; // Example API endpoint

        // 1. Create an HttpClient instance
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2) // Prefer HTTP/2
                .followRedirects(HttpClient.Redirect.NORMAL) // Follow redirects
                .connectTimeout(Duration.ofSeconds(10)) // Connection timeout
                .build();

        // 2. Build the HttpRequest for a GET request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlString))
                .GET() // Specifies GET method (this is the default, but good for clarity)
                .setHeader("User-Agent", "Java HttpClient Example") // Add a custom header
                .build();

        try {
            // 3. Send the request synchronously and get the HttpResponse
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // 4. Process the response
            System.out.println("Status Code: " + response.statusCode());
            System.out.println("Response Body:\n" + response.body());

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
