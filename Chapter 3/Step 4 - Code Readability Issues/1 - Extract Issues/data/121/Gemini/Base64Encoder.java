import java.util.Base64;
import java.nio.charset.StandardCharsets;

public class Base64Encoder {
    public static void main(String[] args) {
        String originalText = "Hello, Base64 in Java!";

        // Get the bytes of the string using a specific charset (e.g., UTF-8)
        byte[] textBytes = originalText.getBytes(StandardCharsets.UTF_8);

        // Encode the bytes to Base64
        String encodedString = Base64.getEncoder().encodeToString(textBytes);

        System.out.println("Original Text: " + originalText);
        System.out.println("Base64 Encoded: " + encodedString);
    }
}
