import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Teste {

    public static void main(String[] args) throws Exception {

        String plainText = "Hello World!";
        String secretKey = "MySecretKey12345";

        // Create an AES key from the provided secret key
        SecretKeySpec keySpec = new SecretKeySpec(secretKey.getBytes(), "AES");

        // Create a cipher instance and initialize it with the key for encryption
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);

        // Encrypt the plaintext and encode it as base64
        byte[] encryptedText = cipher.doFinal(plainText.getBytes());
        String base64Encoded = Base64.getEncoder().encodeToString(encryptedText);

        System.out.println("Plaintext: " + plainText);
        System.out.println("Encrypted and Base64 encoded: " + base64Encoded);
    }
}
