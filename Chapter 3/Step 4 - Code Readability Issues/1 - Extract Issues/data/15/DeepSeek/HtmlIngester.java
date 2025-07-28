import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class HtmlIngester {
    public static void main(String[] args) {
        try {
            // Read HTML from a URL
            URL url = new URL("https://example.com");
            Scanner scanner = new Scanner(url.openStream(), "UTF-8");
            String html = scanner.useDelimiter("\\A").next();
            scanner.close();
            
            System.out.println(html);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}