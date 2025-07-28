import java.io.IOException;
import java.util.Map;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import org.apache.cxf.ws.security.SecurityConstants;
import org.apache.ws.security.WSPasswordCallback;

public class Teste {

    
    public static void main(String[] args) { 
        SService ss = new SService(wsdlURL, SERVICE_NAME);
        Service port = ss.getPort1();
        BindingProvider bp = (BindingProvider) port;
        Map<String, Object> context = bp.getRequestContext();
        //c1 is The alias of the entry in the keystore
        context.put(SecurityConstants.SIGNATURE_USERNAME, "c1");
        context.put(SecurityConstants.CALLBACK_HANDLER, new CallbackHandler() {
            @Override
            public void handle(Callback[] callbacks) throws IOException,
            UnsupportedCallbackException {
                for (int i = 0; i < callbacks.length; i++) {
                        WSPasswordCallback pwcb = (WSPasswordCallback) callbacks[i];
                        String id = pwcb.getIdentifier();
                        if (id.equals("c1")) {
                        pwcb.setPassword("c1-pass");
                    }
                }
            }
            });
        context .put(SecurityConstants.SIGNATURE_PROPERTIES, "crypto.properties");
    }
    
}
