import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class AmexApiService {
    
    private final RestTemplate restTemplate = new RestTemplate();
    private final String clientId = "your_client_id";
    private final String clientSecret = "your_client_secret";
    
    public String getCardDetails(String cardId, String accessToken) {
        String url = "https://api.americanexpress.com/v1/cards/" + cardId;
        
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        HttpEntity<String> entity = new HttpEntity<>(headers);
        
        ResponseEntity<String> response = restTemplate.exchange(
            url, HttpMethod.GET, entity, String.class);
        
        return response.getBody();
    }
    
    public String getAccessToken() {
        String url = "https://api.americanexpress.com/oauth2/v1/token";
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("client_id", clientId);
        map.add("client_secret", clientSecret);
        map.add("grant_type", "client_credentials");
        
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
        
        // Parse response to get access token
        return parseAccessToken(response.getBody());
    }
    
    private String parseAccessToken(String jsonResponse) {
        // Implement JSON parsing
        return "parsed_access_token";
    }
}
