public class Chat {

    public static void main(String[] args) {

        Security.addProvider(new BouncyCastleProvider());

        try (PEMParser pemParser = new PEMParser(new FileReader("certificate.pem"))) {
            Object object = pemParser.readObject();
            if (object instanceof X509CertificateHolder) {
                X509CertificateHolder certHolder = (X509CertificateHolder) object;
                CertificateFactory cf = CertificateFactory.getInstance("X.509");
                ByteArrayInputStream certStream = new ByteArrayInputStream(certHolder.getEncoded());
                cf.generateCertificate(certStream);
            }
        }
    }
}