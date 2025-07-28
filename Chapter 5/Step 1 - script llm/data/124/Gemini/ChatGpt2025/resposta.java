import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateExtractor {
    public static void main(String[] args) {
        String text1 = "Today's date is 12/25/2023.";
        String text2 = "Event on 3/8/2024.";
        String text3 = "No date here.";

        String regex = "\\b(0?\\d|1[0-2])/(0?\\d|[12]\\d|3[01])/(\\d{4})\\b";
        Pattern pattern = Pattern.compile(regex);

        extractDate(text1, pattern);
        extractDate(text2, pattern);
        extractDate(text3, pattern);
    }

    private static void extractDate(String text, Pattern pattern) {
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            System.out.println("Found date: " + matcher.group());
            System.out.println("Month: " + matcher.group(1));
            System.out.println("Day: " + matcher.group(2));
            System.out.println("Year: " + matcher.group(3));
        } else {
            System.out.println("No date found in: \"" + text + "\"");
        }
    }
}
