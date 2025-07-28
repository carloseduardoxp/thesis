import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailExtractor {
    public static void main(String[] args) {
        String input = "Please contact us at support@example.com for assistance.";

        // Simple regex for matching email addresses
        String emailRegex = "[a-zA-Z0-9_+&*-]+(?:\\." +
                            "[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                            "A-Z]{2,7}";

        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            System.out.println("Email found: " + matcher.group());
        } else {
            System.out.println("No email found.");
        }
    }
}
