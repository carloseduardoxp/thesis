import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLParameters;

public class TlsDisableExample {
    private static final String TLS_VERSION = "TLSv1.2";

    public static void main(String[] args) throws Exception {
        // Option 1: Create an SSLContext that only supports TLSv1.2
        SSLContext context = SSLContext.getInstance(TLS_VERSION);
        context.init(null, null, null); // Use default KeyManager and TrustManager

        // Option 2: Explicitly set enabled protocols on an existing SSLSocket/SSLEngine
        SSLSocket anotherSocket = new SSLSocket(); // Or get from an existing connection
        anotherSocket.setEnabledProtocols(new String[]{TLS_VERSION});

        // Option 3: Using SSLParameters
        SSLParameters sslParameters = new SSLParameters();
        sslParameters.setProtocols(new String[]{TLS_VERSION});
        anotherSocket.setSSLParameters(sslParameters);
    }
}
