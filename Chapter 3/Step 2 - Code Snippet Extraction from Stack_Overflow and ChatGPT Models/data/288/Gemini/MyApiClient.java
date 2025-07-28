import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class MyApiClient {

    private final RestClient restClient;

    // Spring Boot auto-configures a RestClient.Builder, which is recommended
    public MyApiClient(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder
            .baseUrl("https://api.example.com") // Set base URL for convenience
            .build();
    }

    public String fetchData() {
        // GET request
        return restClient.get()
                .uri("/data") // Relative URI to the base URL
                .retrieve()  // Start retrieving the response
                .body(String.class); // Convert the response body to String
    }

    public MyResponse postData(MyRequest requestBody) {
        // POST request with a request body
        return restClient.post()
                .uri("/items")
                .contentType(MediaType.APPLICATION_JSON) // Set content type
                .body(requestBody) // Set the request body
                .retrieve()
                .body(MyResponse.class); // Convert the response body to MyResponse object
    }

    public void deleteItem(Long id) {
        // DELETE request
        restClient.delete()
                .uri("/items/{id}", id) // Path variable
                .retrieve()
                .toBodilessEntity(); // No response body expected
    }

    // Example of handling errors
    public String fetchDataWithErrorHandling() {
        try {
            return restClient.get()
                    .uri("/error-endpoint")
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError, (req, res) -> {
                        // Handle 4xx client errors
                        throw new MyCustomClientException("Client error: " + res.statusCode());
                    })
                    .onStatus(HttpStatusCode::is5xxServerError, (req, res) -> {
                        // Handle 5xx server errors
                        throw new MyCustomServerErrorException("Server error: " + res.statusCode());
                    })
                    .body(String.class);
        } catch (MyCustomClientException | MyCustomServerErrorException e) {
            // Log or rethrow specific exceptions
            System.err.println("API call failed: " + e.getMessage());
            return null; // Or throw a more general exception
        }
    }
}

// Dummy classes for demonstration
class MyRequest {
    private String name;
    // Getters and Setters
}

class MyResponse {
    private String status;
    private String message;
    // Getters and Setters
}

// Custom exception classes
class MyCustomClientException extends RuntimeException {
    public MyCustomClientException(String message) {
        super(message);
    }
}

class MyCustomServerErrorException extends RuntimeException {
    public MyCustomServerErrorException(String message) {
        super(message);
    }
}
