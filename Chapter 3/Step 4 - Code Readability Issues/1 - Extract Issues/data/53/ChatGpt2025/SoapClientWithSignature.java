import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.dom.handler.WSHandlerConstants;

import java.util.HashMap;
import java.util.Map;

public class SoapClientWithSignature {

    public static void main(String[] args) {
        // Assume you have a generated CXF client proxy, e.g.
        // MyServicePortType service = new MyService().getMyServicePort();

        MyServicePortType service; // your service proxy

        Client client = ClientProxy.getClient(service);

        Map<String, Object> outProps = new HashMap<>();
        outProps.put(WSHandlerConstants.ACTION, WSHandlerConstants.SIGNATURE);
        outProps.put(WSHandlerConstants.USER, "mykeyalias");

        // Path to keystore
        outProps.put(WSHandlerConstants.SIG_PROP_FILE, "client_sign.properties");

        // Key password
        outProps.put(WSHandlerConstants.PW_CALLBACK_CLASS, ClientKeystorePasswordCallback.class.getName());

        WSS4JOutInterceptor wssOut = new WSS4JOutInterceptor(outProps);
        client.getOutInterceptors().add(wssOut);

        // Now when you invoke service methods, the request will be signed
        service.myOperation();
    }
}
