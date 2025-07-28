import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Chat {

    // Custom exception for encryption/decryption errors
    public static class ChatEncryptionException extends Exception {
        public ChatEncryptionException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    // Encrypt text using AES
    public static String encrypt(String plainText, SecretKey secretKey) throws ChatEncryptionException {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encrypted = cipher.doFinal(plainText.getBytes());
            return Base64.getEncoder().encodeToString(encrypted);
        } catch (Exception e) {
            throw new ChatEncryptionException("Encryption failed", e);
        }
    }

    // Decrypt text using AES
    public static String decrypt(String encryptedText, SecretKey secretKey) throws ChatEncryptionException {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decoded = Base64.getDecoder().decode(encryptedText);
            byte[] decrypted = cipher.doFinal(decoded);
            return new String(decrypted);
        } catch (Exception e) {
            throw new ChatEncryptionException("Decryption failed", e);
        }
    }

    public static void main(String[] args) throws Exception {
        // Generate a 128-bit AES key
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128);
        SecretKey secretKey = keyGen.generateKey();

        String original = "Hello, AES!";
        String encrypted = encrypt(original, secretKey);
        String decrypted = decrypt(encrypted, secretKey);

        System.out.println("Original:  " + original);
        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + decrypted);
    }
}