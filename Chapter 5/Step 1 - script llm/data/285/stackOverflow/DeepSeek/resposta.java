import java.io.*;
import java.net.*;

public class Teste {
    private static final String UTF8 = "UTF-8";

    public static void main(String[] args) throws IOException {        
        String data = URLEncoder.encode("key1", UTF8) + "=" + URLEncoder.encode("value1", UTF8);
        data += "&" + URLEncoder.encode("key2", UTF8) + "=" + URLEncoder.encode("value2", UTF8);
        
        URL url = new URL("http://yourserver.com/whatever");
        URLConnection conn = url.openConnection();
        conn.setDoOutput(true);
        OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
        wr.write(data);
    }
}
