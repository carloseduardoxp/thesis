import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailExtractor {

    public static List<String> extractEmails(String text) {
        List<String> emails = new ArrayList<>();

        // A common regex for email addresses.
        // Note: Email regex can be very complex to cover all edge cases according to RFCs.
        // This one covers most common valid formats.
        String emailRegex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";

        // Compile the regex pattern
        Pattern pattern = Pattern.compile(emailRegex);

        // Create a matcher object for the given text
        Matcher matcher = pattern.matcher(text);

        // Find all matches
        while (matcher.find()) {
            emails.add(matcher.group()); // group() returns the matched substring
        }

        return emails;
    }

    public static void main(String[] args) {
        String text1 = "Please contact support@example.com for assistance or admin@company.net for business inquiries.";
        String text2 = "No email addresses here. Just plain text.";
        String text3 = "My email is user.name+tag@sub.domain.co.uk and also test@123.com.";

        List<String> emails1 = extractEmails(text1);
        System.out.println("Emails in text1: " + emails1);

        List<String> emails2 = extractEmails(text2);
        System.out.println("Emails in text2: " + emails2);

        List<String> emails3 = extractEmails(text3);
        System.out.println("Emails in text3: " + emails3);

        String text4 = "Here are some invalid attempts: invalid@.com, .invalid@domain.com, invalid@domain.";
        List<String> emails4 = extractEmails(text4);
        System.out.println("Emails in text4 (some might be captured by a looser regex): " + emails4);
    }
}
