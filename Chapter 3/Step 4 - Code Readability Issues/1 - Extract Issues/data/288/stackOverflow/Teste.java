
import java.net.http.HttpClient;

public class Teste {

    public static void main(String[] args) {
        HttpClient client = new HttpClient();
        client.getParams().setAuthenticationPreemptive(true);
        Credentials defaultcreds = new UsernamePasswordCredentials("username", "password");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(new CommonsClientHttpRequestFactory(client));
        client.getState().setCredentials(AuthScope.ANY, defaultcreds);
    }
}
