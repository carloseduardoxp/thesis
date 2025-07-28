import java.io.File;
import java.net.URL;

public class Teste {

    public void main() {
        ClassLoader loader = this.getClass().getClassLoader();
        URL url = loader.getResource("resource name");
        String protocol = url.getProtocol();
        if (protocol.equals("jar")) {
            url = new URL(url.getPath());
            protocol = url.getProtocol();
        }
        if (protocol.equals("file")) {
            String[] pathArray = url.getPath().split("!");
            String[] filePath = pathArray[0].split("/", 2);
            new File(filePath[1]);
        }
    }
}
