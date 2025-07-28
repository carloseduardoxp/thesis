import java.io.File;
import java.net.URL;

public class URLToAbsolutePath {
    public static void main(String[] args) throws Exception {
        URL url = new URL("file:///C:/Users/ExampleUser/Documents/test.txt");
        
        // Convert URL to File, then get absolute path
        File file = new File(url.toURI());
        String absolutePath = file.getAbsolutePath();

        System.out.println("Absolute path: " + absolutePath);
    }
}
