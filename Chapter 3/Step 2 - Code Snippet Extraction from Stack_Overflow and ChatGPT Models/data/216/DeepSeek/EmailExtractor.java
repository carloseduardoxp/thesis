import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailExtractor {
    public static void main(String[] args) {
        String text = "Contact us at support@example.com or sales@company.org for more information.";
        
        // Regular expression pattern for matching most email addresses
        Pattern pattern = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
        Matcher matcher = pattern.matcher(text);
        
        while (matcher.find()) {
            System.out.println("Found email: " + matcher.group());
        }
    }
}
