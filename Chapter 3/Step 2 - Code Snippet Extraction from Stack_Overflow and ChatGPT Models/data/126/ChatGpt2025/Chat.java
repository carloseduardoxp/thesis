
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;

import javax.crypto.Cipher;

public class Chat {

    public static void main(String[] args) {
        // Generate or retrieve key from Android Keystore
        KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
// initialize and retrieve SecretKey

// Encrypt password
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptionIv = cipher.getIV();
        byte[] encryptedPassword = cipher.doFinal(password.getBytes(StandardCharsets.UTF_8));

// Save encryptedPassword and IV in SharedPreferences
    }
}
