import javax.net.ssl.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.security.*;
import java.security.cert.CertificateException;

public class HttpsClientWithCustomTrustStore {

    public static void main(String[] args) {
        try {
            // 1. Load the custom TrustStore
            KeyStore trustStore = KeyStore.getInstance("JKS"); // or "PKCS12" if your truststore is a .p12 file
            try (FileInputStream fis = new FileInputStream("/path/to/mytruststore.jks")) {
                trustStore.load(fis, "mypassword".toCharArray());
            }

            // 2. Initialize a TrustManagerFactory with the custom TrustStore
            TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            tmf.init(trustStore);

            // 3. Create an SSLContext using the custom TrustManagers
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, tmf.getTrustManagers(), new SecureRandom()); // null for KeyManagers if no client cert

            // 4. Set the custom SSLSocketFactory for your connection
            URL url = new URL("https://yourserver.com/api/data");
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setSSLSocketFactory(sslContext.getSocketFactory());

            // 5. Make the request
            // ... (e.g., read response, handle errors)
            System.out.println("Response Code: " + conn.getResponseCode());
            // ...
            conn.disconnect();

        } catch (KeyStoreException | IOException | NoSuchAlgorithmException | CertificateException |
                 KeyManagementException e) {
            e.printStackTrace();
        }
    }
}
