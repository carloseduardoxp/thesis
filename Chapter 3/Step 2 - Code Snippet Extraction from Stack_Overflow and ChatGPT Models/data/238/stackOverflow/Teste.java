
import java.io.InputStream;
import java.util.Properties;

public class Teste {

    public void main() {
        final Properties properties = new Properties();
        try (final InputStream stream
                = this.getClass().getResourceAsStream("foo.properties")) {
            properties.load(stream);
            /* or properties.loadFromXML(...) */
        }
    }
}
