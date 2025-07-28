import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberSearch {

    public static void main(String[] args) {
        String text = "Call me at 123-456-7890 or (987) 654-3210. My old number was 111.222.3333.";

        // Regex for common 10-digit formats (with optional spaces, hyphens, or dots)
        String regex = "\\(?\\d{3}\\)?[\\s.-]?\\d{3}[\\s.-]?\\d{4}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        System.out.println("Found US-style phone numbers:");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
