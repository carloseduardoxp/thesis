import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

public class Chat {

    public static class CryptoException extends Exception {
        public CryptoException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    // Encrypt text using AES
    public static String encrypt(String plainText, SecretKey secretKey) throws CryptoException {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encrypted = cipher.doFinal(plainText.getBytes());
            return Base64.getEncoder().encodeToString(encrypted);
        } catch (GeneralSecurityException e) {
            throw new CryptoException("Failed to encrypt data", e);
        }
    }

    // Decrypt text using AES
    public static String decrypt(String encryptedText, SecretKey secretKey) throws CryptoException {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decoded = Base64.getDecoder().decode(encryptedText);
            byte[] decrypted = cipher.doFinal(decoded);
            return new String(decrypted);
        } catch (GeneralSecurityException e) {
            throw new CryptoException("Failed to decrypt data", e);
        }
    }

    public static void main(String[] args) throws CryptoException, NoSuchAlgorithmException {
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
