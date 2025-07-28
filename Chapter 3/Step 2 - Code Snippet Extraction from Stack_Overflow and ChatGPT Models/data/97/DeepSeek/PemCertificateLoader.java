import java.io.BufferedReader;
import java.io.FileReader;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Base64;

public class PemCertificateLoader {
    public static X509Certificate loadPemCertificate(String pemFilePath) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(pemFilePath));
        StringBuilder sb = new StringBuilder();
        String line;
        
        while ((line = reader.readLine()) != null) {
            if (!line.startsWith("-----BEGIN CERTIFICATE-----") && 
                !line.startsWith("-----END CERTIFICATE-----")) {
                sb.append(line);
            }
        }
        reader.close();
        
        byte[] bytes = Base64.getDecoder().decode(sb.toString());
        CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
        return (X509Certificate) certFactory.generateCertificate(new ByteArrayInputStream(bytes));
    }
}
