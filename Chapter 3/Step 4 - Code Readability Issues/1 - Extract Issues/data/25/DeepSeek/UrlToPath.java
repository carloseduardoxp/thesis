import java.io.File;
import java.net.URL;
import java.net.URISyntaxException;

public class UrlToPath {
    public static String urlToAbsolutePath(URL url) throws URISyntaxException {
        if (!"file".equalsIgnoreCase(url.getProtocol())) {
            throw new IllegalArgumentException("URL protocol must be 'file'");
        }
        return new File(url.toURI()).getAbsolutePath();
    }
    
    public static void main(String[] args) throws Exception {
        URL url = new URL("file:/C:/path/to/file.txt");
        String path = urlToAbsolutePath(url);
        System.out.println(path); // Output: C:\path\to\file.txt (on Windows)
    }
}
