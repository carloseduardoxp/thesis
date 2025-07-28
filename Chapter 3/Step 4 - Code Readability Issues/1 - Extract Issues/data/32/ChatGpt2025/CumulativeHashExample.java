import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CumulativeHashExample {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String[] inputs = {"first", "second", "third"};

        MessageDigest digest = MessageDigest.getInstance("SHA-256");

        for (String input : inputs) {
            digest.update(input.getBytes());
        }

        byte[] hashBytes = digest.digest();
        StringBuilder hexString = new StringBuilder();
        for (byte b : hashBytes) {
            hexString.append(String.format("%02x", b));
        }

        System.out.println("Cumulative Hash: " + hexString.toString());
    }
}
