
import javax.net.ssl.*;

public class DeepSeek {

    public static void main(String[] args) {

        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, null, null);

// Create SSLParameters and set protocols
        SSLParameters sslParameters = new SSLParameters();
        sslParameters.setProtocols(new String[]{"TLSv1.2"});

// Apply to HttpsURLConnection
        HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
        HttpsURLConnection.setDefaultHostnameVerifier((hostname, session) -> true);
        HttpsURLConnection.setDefaultSSLParameters(sslParameters);

    }

}
