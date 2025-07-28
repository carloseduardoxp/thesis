        import java.io.File;
import java.net.URL;

public class Teste {

    public static void main(String[] args) {
        URL url = getClass().getResource("/getresources/test.txt");
        File f = new File(url.toURI());
    }
}