import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CumulativeHash {
    private MessageDigest digest;
    private byte[] hashValue;
    
    public CumulativeHash(String algorithm) throws NoSuchAlgorithmException {
        this.digest = MessageDigest.getInstance(algorithm);
        this.hashValue = new byte[digest.getDigestLength()];
    }
    
    public void update(byte[] data) {
        digest.update(data);
        hashValue = digest.digest();
    }
    
    public byte[] getHash() {
        return hashValue.clone();
    }
    
    public String getHashString() {
        StringBuilder sb = new StringBuilder();
        for (byte b : hashValue) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
    
    // Usage example
    public static void main(String[] args) throws NoSuchAlgorithmException {
        CumulativeHash hash = new CumulativeHash("SHA-256");
        
        hash.update("Hello ".getBytes());
        System.out.println("Current hash: " + hash.getHashString());
        
        hash.update("World".getBytes());
        System.out.println("Final hash: " + hash.getHashString());
    }
}
