import java.util.Base64;
import java.nio.charset.StandardCharsets;

public class Base64EncodingExample {

    public static void main(String[] args) {
        String originalString = "Hello, Base64!";

        // 1. Get the Base64 Encoder
        Base64.Encoder encoder = Base64.getEncoder();

        // 2. Convert the string to bytes (important to specify a charset)
        byte[] originalBytes = originalString.getBytes(StandardCharsets.UTF_8);

        // 3. Encode the bytes
        String encodedString = encoder.encodeToString(originalBytes);

        System.out.println("Original String: " + originalString);
        System.out.println("Base64 Encoded String: " + encodedString);

        // --- Decoding (to show the round trip) ---
        // 1. Get the Base64 Decoder
        Base64.Decoder decoder = Base64.getDecoder();

        // 2. Decode the Base64 string back to bytes
        byte[] decodedBytes = decoder.decode(encodedString);

        // 3. Convert the bytes back to a string (using the same charset)
        String decodedString = new String(decodedBytes, StandardCharsets.UTF_8);

        System.out.println("Base64 Decoded String: " + decodedString);
    }
}
