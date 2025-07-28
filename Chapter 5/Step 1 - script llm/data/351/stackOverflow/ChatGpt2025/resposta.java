import java.io.*;

public class Teste {

    public void main() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("plugins.xml")) {
            Xpp3Dom xpp3Dom = Xpp3DomBuilder.build(input);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}