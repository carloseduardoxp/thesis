import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class IndianPhoneValidator {
    // Simplified regex and replaced character classes with characters
    private static final String INDIAN_PHONE_REGEX = "^(?:\\+91[-\\s]?|0)?[6789]\\d{9}$";
    
    public static boolean isValidIndianPhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile(INDIAN_PHONE_REGEX);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
    
    public static void main(String[] args) {
        String[] testNumbers = {
            "9876543210",
            "09876543210",
            "+919876543210",
            "+91-9876543210",
            "919876543210",
            "91-9876543210",
            "1234567890",  // invalid
            "2876543210"   // invalid
        };
        
        for (String number : testNumbers) {
            System.out.println(number + ": " + isValidIndianPhoneNumber(number));
        }
    }
}
