import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IndianPhoneNumberValidator {

    public static void main(String[] args) {
        String[] phoneNumbers = {
                "+919876543210", // Valid - with +91
                "9876543210",   // Valid - 10 digits
                "09876543210",  // Valid - with leading 0
                "919876543210", // Valid - with leading 91
                "123456789",    // Invalid - too short
                "98765432101",  // Invalid - too long
                "+91123456789", // Invalid - starts with 1
                "98765A3210"    // Invalid - contains non-digit
        };

        // Regex for Indian phone numbers
        // This regex allows for the following formats:
        // 1. 10 digits (e.g., 9876543210)
        // 2. Starts with 0 followed by 10 digits (e.g., 09876543210)
        // 3. Starts with +91 followed by 10 digits (e.g., +919876543210)
        // 4. Starts with 91 followed by 10 digits (e.g., 919876543210)
        //
        // Breakdown of the regex:
        // ^                 - Start of the string
        // (?:               - Non-capturing group for the optional prefixes
        //   \\+91           - Matches "+91" literally
        //   |               - OR
        //   0               - Matches "0" literally
        //   |               - OR
        //   91              - Matches "91" literally
        // )?                - Makes the entire non-capturing group optional (0 or 1 time)
        // [6-9]             - Matches a digit from 6 to 9 (Indian mobile numbers typically start with these digits)
        // \\d{9}            - Matches exactly 9 more digits (total of 10 digits for the main number)
        // $                 - End of the string
        String indianPhoneNumberRegex = "^(?:\\+91|0|91)?[6-9]\\d{9}$";

        Pattern pattern = Pattern.compile(indianPhoneNumberRegex);

        System.out.println("Validating Indian Phone Numbers:");
        for (String phoneNumber : phoneNumbers) {
            Matcher matcher = pattern.matcher(phoneNumber);
            if (matcher.matches()) {
                System.out.println("'" + phoneNumber + "' is VALID.");
            } else {
                System.out.println("'" + phoneNumber + "' is INVALID.");
            }
        }
    }
}
