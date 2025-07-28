import java.io.File;
import java.net.URL;

public class FilePathToURL {
    public static void main(String[] args) throws Exception {
        File file = new File("C:/example/test.txt");
        URL url = file.toURI().toURL();
        System.out.println("URL: " + url);
    }
}
