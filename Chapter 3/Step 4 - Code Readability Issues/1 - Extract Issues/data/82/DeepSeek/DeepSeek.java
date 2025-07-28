import java.util.Base64;

public class DeepSeek {

    public static void main(String[] args) {
        String original = "Hello, World!";
        String encoded = Base64.getEncoder().encodeToString(original.getBytes());
        System.out.println(encoded);  // Output: SGVsbG8sIFdvcmxkIQ==
        String urlEncoded = Base64.getUrlEncoder().encodeToString(original.getBytes());
        System.out.println(urlEncoded);
        String mimeEncoded = Base64.getMimeEncoder().encodeToString(original.getBytes());
        System.out.println(mimeEncoded);        
    }
}

