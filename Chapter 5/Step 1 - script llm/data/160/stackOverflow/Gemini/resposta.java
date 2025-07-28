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
    }
}
