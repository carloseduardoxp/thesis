import java.util.regex.*;

public class IndianPhoneValidator {
    public static void main(String[] args) {
        String regex = "^(\\+91[\\-\\s]?|0)?[6-9]\\d{9}$";
        Pattern pattern = Pattern.compile(regex);

        String[] testNumbers = {
            "9876543210", "+91 9876543210", "+91-9876543210",
            "+919876543210", "09876543210", "1234567890"
        };

        for (String number : testNumbers) {
            Matcher matcher = pattern.matcher(number);
            System.out.println(number + " is valid: " + matcher.matches());
        }
    }
}
