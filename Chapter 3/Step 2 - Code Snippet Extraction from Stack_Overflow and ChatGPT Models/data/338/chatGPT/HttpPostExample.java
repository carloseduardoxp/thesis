import java.net.HttpURLConnection;
import java.net.URL;
import java.io.IOException;

public class HttpPostExample {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://example.com/api/post");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.getOutputStream().write(new byte[0]);

        int responseCode = connection.getResponseCode();
        String responseMessage = connection.getResponseMessage();

        System.out.println("Response code: " + responseCode);
        System.out.println("Response message: " + responseMessage);
    }
}
