import java.io.*;

public class Teste {

    public void main() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("plugins.xml")) {
            try (Reader reader = new InputStreamReader(input)) {
                Xpp3DomBuilder.build(input);
            }
        } catch (Exception e) {
            // Handle exception
        }
    }
}
