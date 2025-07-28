import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Teste {

    public static void main(String[] args) throws IOException {
        String charset = StandardCharsets.UTF_8.name();
        String data = URLEncoder.encode("key1", charset) + "=" + URLEncoder.encode("value1", charset);
        data += "&" + URLEncoder.encode("key2", charset) + "=" + URLEncoder.encode("value2", charset);

        URL url = new URL("http://yourserver.com/whatever");
        URLConnection conn = url.openConnection();
        conn.setDoOutput(true);
        try (OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream(), StandardCharsets.UTF_8)) {
            wr.write(data);
        }
    }
}
