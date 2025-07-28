import java.util.Base64;

public class Teste {

    
    public static void main(String[] args) {
        // Encrypt data on your side using BASE64
        byte[] bytesEncoded = Base64.encodeBase64(str.getBytes());
        System.out.println("ecncoded value is " + new String(bytesEncoded));

        // Decrypt data on other side, by processing encoded data
        byte[] valueDecoded= Base64.decodeBase64(bytesEncoded);
        System.out.println("Decoded value is " + new String(valueDecoded));
    }
    
}