import java.util.Base64;

public class Base64Example {
    public static void main(String[] args) {
        String originalText = "Hello, world!";
        String base64EncodedText = Base64.getEncoder().encodeToString(originalText.getBytes());
        System.out.println(base64EncodedText); // Output: SGVsbG8sIHdvcmxkIQ==
    }
}
