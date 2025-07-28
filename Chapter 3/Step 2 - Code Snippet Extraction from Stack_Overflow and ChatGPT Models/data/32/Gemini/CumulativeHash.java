
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class CumulativeHash {

    public static String calculateCumulativeHash(List<?> data, String algorithm) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance(algorithm);

        for (Object item : data) {
            byte[] bytes;
            if (item instanceof String) {
                bytes = ((String) item).getBytes(StandardCharsets.UTF_8);
            } else if (item instanceof byte[]) {
                bytes = (byte[]) item;
            } else {
                // Handle other data types as needed (e.g., serialize objects to bytes)
                bytes = item.toString().getBytes(StandardCharsets.UTF_8);
            }
            digest.update(bytes);
        }

        byte[] hashBytes = digest.digest();
        return bytesToHex(hashBytes);
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        List<String> data = List.of("apple", "banana", "cherry");
        String algorithm = "SHA-256";
        String cumulativeHash = calculateCumulativeHash(data, algorithm);
        System.out.println("Cumulative " + algorithm + " hash: " + cumulativeHash);

        List<byte[]> byteData = List.of("hello".getBytes(StandardCharsets.UTF_8), "world".getBytes(StandardCharsets.UTF_8));
        String cumulativeHashBytes = calculateCumulativeHash(byteData, "MD5");
        System.out.println("Cumulative MD5 hash (bytes): " + cumulativeHashBytes);
    }
}
