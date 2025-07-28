import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

public class StringToInputStreamExample {
    public static void main(String[] args) {
        String text = "Hello, this is a string!";
        
        // Convert String to InputStream
        InputStream inputStream = new ByteArrayInputStream(text.getBytes(StandardCharsets.UTF_8));
        
        // Now you can use inputStream as needed
    }
}
