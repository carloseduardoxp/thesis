import java.util.*;

public class Teste {

    public static void main(String[] args) {        
        if(disabledSSLProtocols != null) {

            String[] protocols = sslEngine.getEnabledProtocols();
            List<String> protocolList = new ArrayList<>();
        
            for (String s : protocols) {
        
                if (disabledSSLProtocols.contains(s)) {
        
                    log4j.info("{} protocol is disabled", s);
                    continue;
                }
        
                log4j.info("{} protocol is enabled", s);
                protocolList.add(s);
            }
        
            sslEngine.setEnabledProtocols(protocolList.toArray(new String[0]));
        }
    }
}
