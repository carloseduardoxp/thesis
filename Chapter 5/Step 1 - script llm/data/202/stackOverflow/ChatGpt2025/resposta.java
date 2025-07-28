import java.net.http.*;

public class Teste {

    public static void main(String[] args) {        
        final HttpClient httpClient = new DefaultHttpClient();
        HttpConnectionParams.setConnectionTimeout(httpClient.getParams(), 10000);
        HttpGet httpget = new HttpGet(SERVER_URL + url);
        httpClient.execute(httpget);
    }
}