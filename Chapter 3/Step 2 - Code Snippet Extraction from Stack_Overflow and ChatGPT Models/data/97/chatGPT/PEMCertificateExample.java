import java.io.FileInputStream;
import java.io.InputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;

public class PEMCertificateExample {
    public static void main(String[] args) throws Exception {
        // Load the certificate file
        InputStream inputStream = new FileInputStream("certificate.pem");

        // Create a CertificateFactory object
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");

        // Generate the certificate object from the PEM encoded input stream
        Certificate certificate = certificateFactory.generateCertificate(inputStream);

        // Print the certificate information
        System.out.println("Type: " + certificate.getType());
        System.out.println("Subject: " + certificate.getSubjectDN());
        System.out.println("Issuer: " + certificate.getIssuerDN());
        System.out.println("Public key: " + certificate.getPublicKey());
    }
}
