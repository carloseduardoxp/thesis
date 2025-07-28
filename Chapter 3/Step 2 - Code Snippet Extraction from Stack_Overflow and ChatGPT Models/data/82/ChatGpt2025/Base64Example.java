import java.util.Base64;

public class Base64Example {
    public static void main(String[] args) {
        String originalString = "Hello, World!";
        
        // Encode
        String encodedString = Base64.getEncoder().encodeToString(originalString.getBytes());
        System.out.println("Encoded string: " + encodedString);
        
        // Decode (optional, to verify)
        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        String decodedString = new String(decodedBytes);
        System.out.println("Decoded string: " + decodedString);
    }
}
