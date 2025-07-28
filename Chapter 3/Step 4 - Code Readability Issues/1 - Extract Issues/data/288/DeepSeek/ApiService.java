import org.springframework.web.client.RestTemplate;

@Service
public class ApiService {
    
    public ResponseEntity<String> callExternalApi() {
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = "https://api.example.com/data";
        
        // For GET request
        ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);
        
        // For POST request
        // HttpHeaders headers = new HttpHeaders();
        // headers.setContentType(MediaType.APPLICATION_JSON);
        // HttpEntity<String> request = new HttpEntity<>("{\"key\":\"value\"}", headers);
        // ResponseEntity<String> response = restTemplate.postForEntity(apiUrl, request, String.class);
        
        return response;
    }
}
