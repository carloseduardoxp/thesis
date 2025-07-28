import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class UrlToAbsolutePath {

    private static final String ABSOLUTE_PATH_PREFIX = "Absolute path for ";

    public static String urlToAbsolutePath(URL url) {
        try {
            File file = new File(url.toURI());
            return file.getAbsolutePath();
        } catch (URISyntaxException e) {
            // Handle the case where the URL cannot be converted to a URI
            System.err.println("Error converting URL to URI: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        try {
            // Example 1: File URL
            URL fileUrl = new URL("file:/home/user/document.txt");
            String absolutePath1 = urlToAbsolutePath(fileUrl);
            System.out.println(ABSOLUTE_PATH_PREFIX + fileUrl + ": " + absolutePath1);

            // Example 2: HTTP URL (will likely not represent a local file path)
            URL httpUrl = new URL("http://www.example.com/index.html");
            String absolutePath2 = urlToAbsolutePath(httpUrl);
            System.out.println(ABSOLUTE_PATH_PREFIX + httpUrl + ": " + absolutePath2);

            // Example 3: URL with spaces in the path
            URL fileUrlWithSpaces = new URL("file:/home/user/My Documents/report.pdf");
            String absolutePath3 = urlToAbsolutePath(fileUrlWithSpaces);
            System.out.println(ABSOLUTE_PATH_PREFIX + fileUrlWithSpaces + ": " + absolutePath3);

        } catch (MalformedURLException e) {
            System.err.println("Malformed URL: " + e.getMessage());
        }
    }
}
