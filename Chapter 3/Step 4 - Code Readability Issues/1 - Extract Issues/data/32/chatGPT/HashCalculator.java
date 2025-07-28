import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashCalculator {
    public static String calculateCumulativeHash(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256"); // Use SHA-256 algorithm
        byte[] hash = md.digest(input.getBytes()); // Calculate the hash of the input string
        String cumulativeHash = bytesToHex(hash); // Convert the hash bytes to a hexadecimal string

        // Iterate over the hash values of the previous strings and calculate the cumulative hash
        for (int i = 0; i < previousHashes.length; i++) {
            byte[] cumulativeInput = (cumulativeHash + previousHashes[i]).getBytes(); // Concatenate the current cumulative hash with the hash of the previous string
            cumulativeHash = bytesToHex(md.digest(cumulativeInput)); // Calculate the new cumulative hash
        }

        return cumulativeHash;
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02X", b)); // Convert each byte to a two-digit hexadecimal string
        }
        return result.toString();
    }
}
