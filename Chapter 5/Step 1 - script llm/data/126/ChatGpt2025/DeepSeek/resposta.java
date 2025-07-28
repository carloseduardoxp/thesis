import java.nio.charset.StandardCharsets;
import java.security.KeyStore;

import javax.crypto.Cipher;

public class Chat {

    public static void main(String[] args) throws Exception {
        // Generate or retrieve key from Android Keystore
        KeyStore.getInstance("AndroidKeyStore");
        // initialize and retrieve SecretKey

        // Encrypt password
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        cipher.getIV();
        cipher.doFinal(password.getBytes(StandardCharsets.UTF_8));

        // Save encryptedPassword and IV in SharedPreferences
    }
}
