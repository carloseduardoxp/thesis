import java.io.File;
import java.net.URL;

public class PathToUrl {
    public static void main(String[] args) {
        String filePath = "/path/to/your/file.txt";
        File file = new File(filePath);
        
        try {
            // Recommended approach - first convert to URI then to URL
            URL url = file.toURI().toURL();
            System.out.println("URL: " + url);
            
            // Older approach (deprecated in Java 20)
            // URL url = file.toURL();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
