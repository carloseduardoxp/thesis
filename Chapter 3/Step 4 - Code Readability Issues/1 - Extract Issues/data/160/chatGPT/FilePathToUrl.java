import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;

public class FilePathToUrl {

    public static void main(String[] args) {
        String filePath = "/path/to/file.txt";
        URL url = null;
        try {
            url = Paths.get(filePath).toUri().toURL();
            System.out.println("URL: " + url.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}

class UrlToFilePath {

    public static void main(String[] args) {
        String urlString = "http://www.example.com/path/to/file.txt";
        URL url = null;
        try {
            url = new URL(urlString);
            File file = new File(url.getFile());
            String filePath = file.getAbsolutePath();
            System.out.println("File path: " + filePath);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
