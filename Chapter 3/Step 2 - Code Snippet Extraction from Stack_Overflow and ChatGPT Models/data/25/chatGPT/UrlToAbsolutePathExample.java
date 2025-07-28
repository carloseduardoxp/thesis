import java.net.URL;

public class UrlToAbsolutePathExample {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://example.com/myfile.txt");
        String absolutePath = url.getPath();
        System.out.println(absolutePath);
    }
}
