import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String text = "This is a sample text with an email address: john.doe@example.com. Please contact me at this email address.";

        // Define a regular expression pattern to match email addresses
        Pattern pattern = Pattern.compile("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b");

        // Get a matcher object to match the pattern against the input text
        Matcher matcher = pattern.matcher(text);

        // Find the first match
        if (matcher.find()) {
            // Extract the email address
            String email = matcher.group();

            System.out.println("Found email address: " + email);
        } else {
            System.out.println("No email address found.");
        }
    }
}
