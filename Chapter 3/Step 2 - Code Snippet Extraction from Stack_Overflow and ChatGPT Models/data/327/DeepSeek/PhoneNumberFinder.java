import java.util.regex.*;

public class PhoneNumberFinder {
    public static void main(String[] args) {
        String text = "Contact us at 123-456-7890 or (123) 456-7890 or +1 123.456.7890";
        
        // Regex pattern for common phone number formats
        String regex = "(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}" 
                     + "|\\d{3}[- .]?\\d{4}";
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        
        while (matcher.find()) {
            System.out.println("Found phone number: " + matcher.group());
        }
    }
}
