import java.util.Base64;

public class Base64EncodingExample {
    public static void main(String[] args) {
        // Encode a string
        String originalString = "Hello, world!";
        String encodedString = Base64.getEncoder().encodeToString(originalString.getBytes());
        System.out.println("Encoded string: " + encodedString);
        
        // Decode the string
        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        String decodedString = new String(decodedBytes);
        System.out.println("Decoded string: " + decodedString);
    }
}
