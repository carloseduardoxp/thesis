import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Teste {

    public static void main(String[] args) throws IOException {
        HttpClient client = HttpClients.createDefault();
        HttpPost request = new HttpPost("http://www.example.com");

        List<NameValuePair> pairs = new ArrayList<>();
        pairs.add(new BasicNameValuePair("paramName", "paramValue"));

        request.setEntity(new UrlEncodedFormEntity(pairs));
        client.execute(request);
    }
}
