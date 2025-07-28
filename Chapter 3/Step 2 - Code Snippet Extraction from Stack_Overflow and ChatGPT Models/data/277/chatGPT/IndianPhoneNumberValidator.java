import java.util.regex.Pattern;

public class IndianPhoneNumberValidator {
    public static void main(String[] args) {
        String regex = "^\\+91[6789]\\d{9}$";
        Pattern pattern = Pattern.compile(regex);
        
        String phoneNumber1 = "+919876543210"; // valid phone number
        String phoneNumber2 = "+9176543210";   // invalid phone number
        
        System.out.println("Phone number 1 is valid: " + pattern.matcher(phoneNumber1).matches());
        System.out.println("Phone number 2 is valid: " + pattern.matcher(phoneNumber2).matches());
    }
}
