import javax.crypto.Cipher;

public class Chat {

    public static void main(String[] args) {
        // Generate or retrieve key from Android Keystore
        // initialize and retrieve SecretKey

        // Encrypt password
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        // Save encryptedPassword and IV in SharedPreferences
    }
}
