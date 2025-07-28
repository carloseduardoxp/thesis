import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

public class StringToInputStream {
    public static void main(String[] args) {
        String str = "Hello, World!";

        // Convert String to InputStream and use it directly
        InputStream inputStream = new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8));
        // Use the inputStream...
    }
}