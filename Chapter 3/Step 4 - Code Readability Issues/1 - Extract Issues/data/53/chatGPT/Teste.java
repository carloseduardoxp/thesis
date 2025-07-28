import java.util.List;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.common.crypto.CryptoFactory;
import org.apache.wss4j.common.crypto.Crypto;
import org.apache.wss4j.common.ext.WSSecurityException;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.handler.WSHandlerConstants;

// ...

public class Teste {

public static void main(String[] args) {

        // create a new instance of your SOAP client
        MySoapClient client = new MySoapClient();

        // get the client proxy
        Object proxy = ClientProxy.getClient(client);

        // create a WSS4JOutInterceptor instance
        WSS4JOutInterceptor wssOut = new WSS4JOutInterceptor();

        // create a Crypto instance to provide the key store and private key
        Crypto crypto = CryptoFactory.getInstance("clientKeystore.properties");

        // configure the interceptor to use the crypto instance
        wssOut.setProperty(WSHandlerConstants.ACTION, WSHandlerConstants.SIGNATURE);
        wssOut.setProperty(WSHandlerConstants.USER, "client");
        wssOut.setProperty(WSHandlerConstants.SIG_PROP_REF_ID, "clientCrypto");
        wssOut.setProperty(WSHandlerConstants.SIG_KEY_ID, WSConstants.THUMBPRINT_IDENTIFIER);
        wssOut.setProperty("clientCrypto", crypto);

        // add the interceptor to the client proxy's interceptor chain
        List<Interceptor<? extends Message>> interceptors = ClientProxy.getClient(client).getOutInterceptors();
        interceptors.add(wssOut);

    }

}