import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.BadPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Chat {

    // Encrypt text using AES
    public static String encrypt(String plainText, SecretKey secretKey) 
            throws NoSuchPaddingException, NoSuchAlgorithmException, 
                   InvalidKeyException, IllegalBlockSizeException, 
                   BadPaddingException {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encrypted = cipher.doFinal(plainText.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    }

    // Decrypt text using AES
    public static String decrypt(String encryptedText, SecretKey secretKey) 
            throws NoSuchPaddingException, NoSuchAlgorithmException, 
                   InvalidKeyException, IllegalBlockSizeException, 
                   BadPaddingException {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decoded = Base64.getDecoder().decode(encryptedText);
        byte[] decrypted = cipher.doFinal(decoded);
        return new String(decrypted);
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