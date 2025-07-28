import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Locale;
import java.util.ResourceBundle;

public class Teste {

    public static void main(String[] args) throws Exception {
        // Path to your file, if you have it on local, use something like C:\\MyFolder or /home/usr/etc
        File file = new File("YOUR_PATH");
        URL[] url = file.toURI().toURL();
        ResourceBundle.getBundle("MessageBundle", Locale.CANADA_FRENCH, new URLClassLoader(url));
    }
}