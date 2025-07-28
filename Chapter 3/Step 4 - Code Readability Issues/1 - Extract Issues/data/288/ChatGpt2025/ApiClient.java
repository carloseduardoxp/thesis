import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

public class ApiClient {

    private RestTemplate restTemplate = new RestTemplate();

    public String callApi() {
        String url = "https://api.example.com/data";
        
        // For GET request
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            // Handle errors here
            return null;
        }
    }
}
