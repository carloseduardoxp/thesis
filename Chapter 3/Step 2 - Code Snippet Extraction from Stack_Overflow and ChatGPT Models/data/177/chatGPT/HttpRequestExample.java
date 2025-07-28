import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequestExample {

  public static void main(String[] args) throws Exception {

    // Set up the URL and open a connection
    URL url = new URL("http://example.com");
    HttpURLConnection con = (HttpURLConnection) url.openConnection();

    // Set the request method (GET, POST, etc.)
    con.setRequestMethod("GET");

    // Set the request header
    con.setRequestProperty("User-Agent", "Mozilla/5.0");

    // Send the request and receive the response
    int responseCode = con.getResponseCode();
    System.out.println("Response Code: " + responseCode);
  }
}
