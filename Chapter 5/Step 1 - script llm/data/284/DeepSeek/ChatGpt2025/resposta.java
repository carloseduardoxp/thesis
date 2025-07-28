import java.io.InputStream;
import java.net.URL;
import java.security.KeyStore;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.net.ssl.*;

public class CustomCertificateHTTPS {
    public static void main(String[] args) throws Exception {
        // Load your custom certificate (e.g., from a file)
        InputStream certStream = CustomCertificateHTTPS.class.getResourceAsStream("/path/to/certificate.crt");
        
        // Create a CertificateFactory and generate the certificate
        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        X509Certificate caCert = (X509Certificate)cf.generateCertificate(certStream);
        
        // Create a KeyStore containing our trusted certificate
        KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
        trustStore.load(null, null); // Initialize an empty keystore
        trustStore.setCertificateEntry("caCert", caCert);
        
        // Create a TrustManager that trusts the certs in our KeyStore
        TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        tmf.init(trustStore);
        
        // Create an SSLContext that uses our TrustManager
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, tmf.getTrustManagers(), null);
        
        // Use the custom SSLContext for your HTTPS request
        HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
        
        // Now make your HTTPS request as usual
        URL url = new URL("https://example.com/api");
        HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
        // ... use the connection as needed
    }
}