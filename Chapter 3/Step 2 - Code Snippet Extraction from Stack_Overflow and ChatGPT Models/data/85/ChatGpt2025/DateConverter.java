import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class DateConverter {
    public static void main(String[] args) {
        // Example numeric date string
        String numericDate = "2025-05-20";

        // Parse the numeric date string to a LocalDate object
        LocalDate date = LocalDate.parse(numericDate);

        // Define an alphanumeric format (e.g., "20 May 2025")
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.ENGLISH);

        // Format the date
        String alphaDate = date.format(formatter);

        System.out.println("Alphanumeric date: " + alphaDate);
    }
}
