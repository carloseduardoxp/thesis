
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class Teste {

    public static void main(String[] args) {
        HttpClient client = new DefaultHttpClient();
        HttpPost request = new HttpPost("www.example.com");

        List<NameValuePair> pairs = new ArrayList<NameValuePair>();
        pairs.add(new BasicNameValuePair("paramName", "paramValue"));

        request.setEntity(new UrlEncodedFormEntity(pairs));
        HttpResponse resp = client.execute(request);

    }
}
