import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class ParseHTML {

    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.website.com");
        URLConnection spoof = url.openConnection();

        spoof.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.5; Windows NT 5.0;    H010818)");
        BufferedReader in = new BufferedReader(new InputStreamReader(spoof.getInputStream()));
        String strLine = "";
        
        while ((strLine = in.readLine()) != null) {
            // Process each line as needed
        }
    }
}