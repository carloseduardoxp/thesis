import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Base64;

public class PemCertificateLoader {

    public static X509Certificate loadX509Certificate(String pemCertificateString) throws CertificateException {
        // Remove BEGIN/END CERTIFICATE headers and footers, and any newlines
        String certContent = pemCertificateString
                .replaceAll("-----BEGIN CERTIFICATE-----", "")
                .replaceAll("-----END CERTIFICATE-----", "")
                .replaceAll("\\s", ""); // Remove all whitespace (including newlines)

        byte[] decodedCert = Base64.getDecoder().decode(certContent);

        CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
        return (X509Certificate) certFactory.generateCertificate(new ByteArrayInputStream(decodedCert));
    }

    public static X509Certificate loadX509CertificateFromFile(String filePath) throws Exception {
        StringBuilder pemBuilder = new StringBuilder();
        try (FileReader reader = new FileReader(filePath)) {
            int charRead;
            while ((charRead = reader.read()) != -1) {
                pemBuilder.append((char) charRead);
            }
        }
        return loadX509Certificate(pemBuilder.toString());
    }

    public static void main(String[] args) {
        String pemCert = "-----BEGIN CERTIFICATE-----\n" +
                         "MIIDbzCCAlegAwIBAgIJAN2lB08n8iKDMA0GCSqGSIb3DQEBCwUAMGwxCzAJBgNV\n" +
                         "BAYTAlVTMQswCQYDVQQIDAJDQTEUMBIGA1UEBwwLU2FuIEZyYW5jaXNjbzERMA8G\n" +
                         "A1UECgwIQ29tY2FzdDEQMA4GA1UECwwHV2ViU2l0ZTEQMA4GA1UEAwwHY29tY2Fz\n" +
                         "dC5jb20wHhcNMjMwMTE1MDgyMzEyWhcNMjQwMTE1MDgyMzEyWjBsMQswCQYDVQQG\n" +
                         "EwJVUzELMAkGA1UECAwCQ0ExFDASBgNVBAcMC1NhbiBGcmFuY2lzY28xETAPBgNV\n" +
                         "BAoMCHENb21jYXN0MRAwDgYDVQQLDAdXZWJTaXRlMRAwDgYDVQQDDAdjb21jYXN0\n" +
                         "LmNvbTCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAMmX1f5z+V2S54fS\n" +
                         "75Jj0Q0Xy+z+J5s+3/gQ8X2v5L+6f+o+4/g+P5+o/5+Q+o/5+R+o/5+S+o/5+T+o\n" +
                         "+5+V+o/5+W+o/5+X+o/5+Y+o/5+Z+o/5+a+o/5+b+o/5+c+o/5+d+o/5+e+o/5+f\n" +
                         "++++AIBATANBgkqhkiG9w0BAQsFAAOCAQEAMmX1f5z+V2S54fS75Jj0Q0Xy+z+J5\n" +
                         "s+3/gQ8X2v5L+6f+o+4/g+P5+o/5+Q+o/5+R+o/5+S+o/5+T+o+5+V+o/5+W+o/5\n" +
                         "+X+o/5+Y+o/5+Z+o/5+a+o/5+b+o/5+c+o/5+d+o/5+e+o/5+f++++\n" +
                         "-----END CERTIFICATE-----";

        try {
            X509Certificate certificate = loadX509Certificate(pemCert);
            System.out.println("Certificate Subject: " + certificate.getSubjectX500Principal());
            System.out.println("Certificate Issuer: " + certificate.getIssuerX500Principal());
            System.out.println("Certificate Valid From: " + certificate.getNotBefore());
            System.out.println("Certificate Valid Until: " + certificate.getNotAfter());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}