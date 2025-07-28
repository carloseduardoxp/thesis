import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLParameters;

public class TlsDisableExample {
    private static final String TLS_V1_2 = "TLSv1.2";

    public static void main(String[] args) throws Exception {
        // Option 1: Create an SSLContext that only supports TLSv1.2
        SSLContext context = SSLContext.getInstance(TLS_V1_2);
        context.init(null, null, null); // Use default KeyManager and TrustManager

        // When creating SSLSockets or SSLEngines from this context,
        // they will default to TLSv1.2.

        // Option 2: Explicitly set enabled protocols on an existing SSLSocket/SSLEngine
        // (if you didn't create it with a specific SSLContext)
        SSLSocket anotherSocket = new SSLSocket(); // Or get from an existing connection
        anotherSocket.setEnabledProtocols(new String[]{TLS_V1_2});

        // Option 3: Using SSLParameters
        SSLParameters sslParameters = new SSLParameters();
        sslParameters.setProtocols(new String[]{TLS_V1_2});
        anotherSocket.setSSLParameters(sslParameters);
    }
}
