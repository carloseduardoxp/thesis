import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordHasher {

    public static void main(String[] args) {
        // Create an encoder instance.
        // You can specify a "strength" (cost factor) if you want to make it slower/more secure.
        // The default strength is 10, which is generally good.
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String plainPassword = "MySecretPassword123!";

        // 1. Hash the password
        String hashedPassword = encoder.encode(plainPassword);
        System.out.println("Plain Password: " + plainPassword);
        System.out.println("Hashed Password: " + hashedPassword);

        // In a real application, you would store 'hashedPassword' and the user's username
        // in your database.

        // 2. Verify a password (e.g., during login)
        String inputPasswordAttempt = "MySecretPassword123!";
        String wrongPasswordAttempt = "WrongPassword";

        boolean isPasswordCorrect = encoder.matches(inputPasswordAttempt, hashedPassword);
        System.out.println("Password '" + inputPasswordAttempt + "' matches: " + isPasswordCorrect); // Should be true

        boolean isWrongPasswordCorrect = encoder.matches(wrongPasswordAttempt, hashedPassword);
        System.out.println("Password '" + wrongPasswordAttempt + "' matches: " + isWrongPasswordCorrect); // Should be false
    }
}
