import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateExtractor {
    public static void main(String[] args) {
        String text = "The event will occur on 2023-12-25 or maybe 12/31/2023 or 25-Dec-2023";
        
        // Pattern 1: YYYY-MM-DD
        extractDates(text, "\\d{4}-\\d{2}-\\d{2}", "YYYY-MM-DD");
        
        // Pattern 2: MM/DD/YYYY
        extractDates(text, "\\d{2}/\\d{2}/\\d{4}", "MM/DD/YYYY");
        
        // Pattern 3: DD-MMM-YYYY
        extractDates(text, "\\d{2}-[A-Za-z]{3}-\\d{4}", "DD-MMM-YYYY");
        
        // More comprehensive pattern (handles multiple formats)
        extractDates(text, "\\b(?:\\d{4}[/-]\\d{2}[/-]\\d{2}|\\d{2}[/-]\\d{2}[/-]\\d{4}|\\d{2}-[A-Za-z]{3}-\\d{4})\\b", 
                   "Multiple formats");
    }
    
    private static void extractDates(String text, String regex, String patternName) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        
        System.out.println("\nExtracting dates with " + patternName + " pattern:");
        while (matcher.find()) {
            System.out.println("Found date: " + matcher.group());
        }
    }
}
