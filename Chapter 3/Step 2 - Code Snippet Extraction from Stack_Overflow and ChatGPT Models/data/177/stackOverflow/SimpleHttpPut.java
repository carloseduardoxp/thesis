
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

public class SimpleHttpPut {

    public static void main(String[] args) {
        try {
            DefaultHttpClient httpclient = new DefaultHttpClient();
            String url = "http://localhost";
            HttpPost httpPost = new HttpPost(url);

            httpPost.addHeader("header-name", "header-value");

            HttpResponse response = httpclient.execute(httpPost);

            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String line = "";
            while ((line = rd.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
