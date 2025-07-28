import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

public class StringToInputStreamExample {
    public static void main(String[] args) {
        String text = "Hello, this is a string!";
        new ByteArrayInputStream(text.getBytes(StandardCharsets.UTF_8));
    }
}