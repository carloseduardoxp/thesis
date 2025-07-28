import java.util.Base64;

public class Base64Example {
    public static void main(String[] args) {
        String originalText = "Hello, World!";
        
        // Encode to Base64
        String encodedString = Base64.getEncoder().encodeToString(originalText.getBytes());
        System.out.println("Encoded: " + encodedString);
        
        // Decode back to original
        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        String decodedString = new String(decodedBytes);
        System.out.println("Decoded: " + decodedString);
    }
}
