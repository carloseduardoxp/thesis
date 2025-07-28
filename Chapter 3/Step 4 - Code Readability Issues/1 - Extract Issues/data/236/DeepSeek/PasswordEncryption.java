import org.mindrot.jbcrypt.BCrypt;

public class PasswordEncryption {
    public static String hashPassword(String plainTextPassword) {
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }
    
    public static boolean checkPassword(String plainTextPassword, String hashedPassword) {
        return BCrypt.checkpw(plainTextPassword, hashedPassword);
    }
    
    public static void main(String[] args) {
        String password = "mySecurePassword123";
        String hashed = hashPassword(password);
        
        System.out.println("Hashed password: " + hashed);
        System.out.println("Password check: " + checkPassword(password, hashed));
    }
}
