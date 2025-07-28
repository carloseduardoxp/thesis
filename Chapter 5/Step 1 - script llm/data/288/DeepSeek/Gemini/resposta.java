import org.springframework.web.client.RestTemplate;

@Service
public class ApiService {
    
    public ResponseEntity<String> callExternalApi() {
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = "https://api.example.com/data";
        
        return restTemplate.getForEntity(apiUrl, String.class);
    }
}
