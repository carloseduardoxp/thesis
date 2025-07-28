
import android.content.Context;
import android.content.SharedPreferences;
import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKeys;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class SecurePreferencesManager {

    private static final String PREF_FILE_NAME = "my_secure_prefs";
    private static final String KEY_AUTH_TOKEN = "auth_token"; // Example key for an auth token

    private SharedPreferences secureSharedPreferences;

    public SecurePreferencesManager(Context context) {
        try {
            // 1. Create or retrieve the master key
            // This key is used to encrypt the SharedPreferences file.
            // It's securely stored in the Android KeyStore.
            String masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC);

            // 2. Initialize EncryptedSharedPreferences
            secureSharedPreferences = EncryptedSharedPreferences.create(
                    PREF_FILE_NAME,
                    masterKeyAlias,
                    context,
                    EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                    EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
            );
        } catch (GeneralSecurityException | IOException e) {
            e.printStackTrace();
            // Handle the error appropriately, e.g., log it, show a message to the user, or exit.
            // In a real app, you might want to consider what happens if secure storage fails.
        }
    }

    /**
     * Stores an authentication token securely.
     * @param token The authentication token to store.
     */
    public void saveAuthToken(String token) {
        if (secureSharedPreferences != null) {
            secureSharedPreferences.edit()
                .putString(KEY_AUTH_TOKEN, token)
                .apply();
        }
    }

    /**
     * Retrieves the stored authentication token.
     * @return The stored authentication token, or null if not found.
     */
    public String getAuthToken() {
        if (secureSharedPreferences != null) {
            return secureSharedPreferences.getString(KEY_AUTH_TOKEN, null);
        }
        return null;
    }

    /**
     * Clears the stored authentication token.
     */
    public void clearAuthToken() {
        if (secureSharedPreferences != null) {
            secureSharedPreferences.edit()
                .remove(KEY_AUTH_TOKEN)
                .apply();
        }
    }
}
