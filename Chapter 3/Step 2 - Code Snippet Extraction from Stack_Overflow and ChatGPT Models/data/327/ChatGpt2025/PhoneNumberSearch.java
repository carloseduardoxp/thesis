import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberSearch {
    public static void main(String[] args) {
        String text = "Call me at (123) 456-7890 or 987-654-3210.";
        
        // Regex pattern for US phone number format
        String phonePattern = "\\(?\\d{3}\\)?[-.\\s]?\\d{3}[-.\\s]?\\d{4}";
        
        Pattern pattern = Pattern.compile(phonePattern);
        Matcher matcher = pattern.matcher(text);
        
        while (matcher.find()) {
            System.out.println("Found phone number: " + matcher.group());
        }
    }
}
