import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class Gemini {

    private SecretKey secretKey;
    private IvParameterSpec ivParameterSpec;

    public Gemini() throws GeminiCryptoException {
        try {
            // Generate a new AES key
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(256); // You can use 128, 192, or 256 bits
            secretKey = keyGenerator.generateKey();

            // Generate a random Initialization Vector (IV)
            byte[] iv = new byte[16]; // AES block size is 16 bytes
            SecureRandom secureRandom = new SecureRandom();
            secureRandom.nextBytes(iv);
            ivParameterSpec = new IvParameterSpec(iv);
        } catch (Exception e) {
            throw new GeminiCryptoException("Error initializing Gemini", e);
        }
    }

    public String encrypt(String plainText) throws GeminiCryptoException {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding"); // Using CBC mode with PKCS5Padding
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);
            byte[] encryptedBytes = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
            // Combine IV and encrypted data for decryption later
            byte[] combined = new byte[ivParameterSpec.getIV().length + encryptedBytes.length];
            System.arraycopy(ivParameterSpec.getIV(), 0, combined, 0, ivParameterSpec.getIV().length);
            System.arraycopy(encryptedBytes, 0, combined, ivParameterSpec.getIV().length, encryptedBytes.length);
            return Base64.getEncoder().encodeToString(combined);
        } catch (Exception e) {
            throw new GeminiCryptoException("Error encrypting text", e);
        }
    }

    public String decrypt(String encryptedText) throws GeminiCryptoException {
        try {
            byte[] combined = Base64.getDecoder().decode(encryptedText);
            byte[] iv = new byte[16];
            byte[] encryptedBytes = new byte[combined.length - iv.length];

            System.arraycopy(combined, 0, iv, 0, iv.length);
            System.arraycopy(combined, iv.length, encryptedBytes, 0, encryptedBytes.length);

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(iv));
            byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
            return new String(decryptedBytes, StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new GeminiCryptoException("Error decrypting text", e);
        }
    }

    public static void main(String[] args) {
        try {
            Gemini aes = new Gemini();
            String originalText = "This is the text I want to encrypt!";
            String encrypted = aes.encrypt(originalText);
            String decrypted = aes.decrypt(encrypted);

            System.out.println("Original Text: " + originalText);
            System.out.println("Encrypted Text: " + encrypted);
            System.out.println("Decrypted Text: " + decrypted);

        } catch (GeminiCryptoException e) {
            e.printStackTrace();
        }
    }
}

class GeminiCryptoException extends Exception {
    public GeminiCryptoException(String message, Throwable cause) {
        super(message, cause);
    }
}