import java.io.File;
import java.net.URL;

public class Teste {

    public static void main(String[] args) throws Exception {
        URL url = Teste.class.getResource("/getresources/test.txt");
        new File(url.toURI());
    }
}
