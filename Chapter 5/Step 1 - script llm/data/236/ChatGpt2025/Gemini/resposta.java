import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class PasswordEncryptor {

    public static class PasswordEncryptionException extends RuntimeException {
        public PasswordEncryptionException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static String encryptPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            // Encode bytes to Base64 to get a readable string
            return Base64.getEncoder().encodeToString(hashBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new PasswordEncryptionException("Error encrypting password", e);
        }
    }

    public static void main(String[] args) {
        String password = "mySecret123";
        String encryptedPassword = encryptPassword(password);
        System.out.println("Encrypted password: " + encryptedPassword);
    }
}
