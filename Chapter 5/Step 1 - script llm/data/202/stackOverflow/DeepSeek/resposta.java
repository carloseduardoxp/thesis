import java.net.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;

public class Teste {
    private static final String SERVER_URL = "http://example.com/";
    private static final String url = "endpoint";

    public static void main(String[] args) throws Exception {        
        HttpClient httpClient = new DefaultHttpClient();
        HttpConnectionParams.setConnectionTimeout(httpClient.getParams(), 10000);
        HttpGet httpget = new HttpGet(SERVER_URL + url);
        httpClient.execute(httpget);
    }
}
