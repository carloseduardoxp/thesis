
import java.io.File;
import java.net.URL;

public class Teste {

    public void main() {
        ClassLoader loader = this.getClass().getClassLoader();
        URL url = loader.getResource("resource name");
        String[] filePath = null;
        String protocol = url.getProtocol();
        if (protocol.equals("jar")) {
            url = new URL(url.getPath());
            protocol = url.getProtocol();
        }
        if (protocol.equals("file")) {
            String[] pathArray = url.getPath().split("!");
            filePath = pathArray[0].split("/", 2);
        }
        File required = new File(FilePath[1]);
    }
}
