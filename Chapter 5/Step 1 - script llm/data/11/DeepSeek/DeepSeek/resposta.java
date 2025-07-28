import java.security.SecureRandom;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class DeepSeek {

    public static void main(String[] args) throws EncryptionException {
        // Generate a secret key
        SecretKey secretKey = generateKey(128);
        
        // Generate initialization vector
        byte[] iv = generateIv();
        
        String originalMessage = "This is a secret message";
        System.out.println("Original: " + originalMessage);
        
        // Encrypt
        String encrypted = encrypt(originalMessage, secretKey, iv);
        System.out.println("Encrypted: " + encrypted);
        
        // Decrypt
        String decrypted = decrypt(encrypted, secretKey, iv);
        System.out.println("Decrypted: " + decrypted);
    }
    
    public static SecretKey generateKey(int keySize) throws EncryptionException {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(keySize);
            return keyGenerator.generateKey();
        } catch (Exception e) {
            throw new EncryptionException("Failed to generate secret key", e);
        }
    }
    
    public static byte[] generateIv() {
        byte[] iv = new byte[16]; // 16 bytes for AES
        new SecureRandom().nextBytes(iv);
        return iv;
    }
    
    public static String encrypt(String input, SecretKey key, byte[] iv) throws EncryptionException {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec ivSpec = new IvParameterSpec(iv);
            cipher.init(Cipher.ENCRYPT_MODE, key, ivSpec);
            byte[] encryptedBytes = cipher.doFinal(input.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            throw new EncryptionException("Encryption failed", e);
        }
    }
    
    public static String decrypt(String encrypted, SecretKey key, byte[] iv) throws EncryptionException {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec ivSpec = new IvParameterSpec(iv);
            cipher.init(Cipher.DECRYPT_MODE, key, ivSpec);
            byte[] decodedBytes = Base64.getDecoder().decode(encrypted);
            byte[] decryptedBytes = cipher.doFinal(decodedBytes);
            return new String(decryptedBytes);
        } catch (Exception e) {
            throw new EncryptionException("Decryption failed", e);
        }
    }
    
    static class EncryptionException extends Exception {
        public EncryptionException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}