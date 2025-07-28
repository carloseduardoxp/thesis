
import java.io.*;
import java.net.*;
import java.security.*;
import java.security.cert.*;
import javax.net.ssl.*;

public class Teste {
  public static void main(String[] args) {
    // Load the certificate from a file
    FileInputStream certFile = new FileInputStream("path/to/certificate.crt");
    CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
    X509Certificate cert = (X509Certificate) certFactory.generateCertificate(certFile);

    // Create a keystore containing the certificate
    KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
    keyStore.load(null, null);
    keyStore.setCertificateEntry("myCert", cert);

    // Create an SSL context using the keystore
    TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
    tmf.init(keyStore);
    SSLContext sslContext = SSLContext.getInstance("TLS");
    sslContext.init(null, tmf.getTrustManagers(), null);

    // Use the SSL context to create an HTTPS connection
    URL url = new URL("https://example.com");
    HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
    conn.setSSLSocketFactory(sslContext.getSocketFactory());

    // Send the HTTPS request
    conn.setRequestMethod("GET");
    conn.connect();

    // Read the HTTPS response
    InputStream in = conn.getInputStream();
    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
    String line;
    while ((line = reader.readLine()) != null) {
        System.out.println(line);
    }

  }
}
