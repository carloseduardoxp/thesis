import javax.net.ssl.*;
import java.io.FileInputStream;
import java.net.URL;
import java.security.KeyStore;

public class HttpsClientWithCert {

    public static void main(String[] args) throws Exception {
        // Load client certificate (PKCS12 or JKS)
        String keystorePath = "client.p12";
        String keystorePassword = "password";

        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        try (FileInputStream fis = new FileInputStream(keystorePath)) {
            keyStore.load(fis, keystorePassword.toCharArray());
        }

        // KeyManager for client cert
        KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
        kmf.init(keyStore, keystorePassword.toCharArray());
        KeyManager[] keyManagers = kmf.getKeyManagers();

        // TrustManager for trusting server certs (use default truststore)
        TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
        tmf.init((KeyStore) null);
        TrustManager[] trustManagers = tmf.getTrustManagers();

        // Initialize SSLContext with client cert and default trust managers
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(keyManagers, trustManagers, null);

        // Set default SSL socket factory for HttpsURLConnection
        HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());

        // Make HTTPS request
        URL url = new URL("https://example.com");
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        // Optional: handle response
        int responseCode = conn.getResponseCode();
        System.out.println("Response Code: " + responseCode);

        // Read response if needed...
    }
}
