import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateExtractor {
    public static void main(String[] args) {
        String input = "The event is scheduled on 21/05/2025 at 10 AM.";
        
        // Regex pattern for date dd/mm/yyyy
        String regex = "\\b(\\d{2}/\\d{2}/\\d{4})\\b";
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        
        if (matcher.find()) {
            String date = matcher.group(1);
            System.out.println("Found date: " + date);
        } else {
            System.out.println("No date found.");
        }
    }
}
