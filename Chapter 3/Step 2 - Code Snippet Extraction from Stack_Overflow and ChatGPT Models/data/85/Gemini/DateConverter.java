import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class DateConverter {

    public static String convertNumericToAlphanumeric(String numericDate) {
        // Define the input format (assuming "yyyy-MM-dd")
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Parse the numeric date string into a LocalDate object
        LocalDate date = LocalDate.parse(numericDate, inputFormatter);

        // Define the output format (e.g., "MMMM d, yyyy" for "October 26, 2023")
        // You can choose different FormatStyle or define a custom pattern
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)
                                                .withLocale(Locale.ENGLISH); // Or your desired locale

        // Format the LocalDate object into the alphanumeric string
        return date.format(outputFormatter);
    }

    public static void main(String[] args) {
        String numericDate = "2023-10-26";
        String alphanumericDate = convertNumericToAlphanumeric(numericDate);
        System.out.println("Numeric Date: " + numericDate);
        System.out.println("Alphanumeric Date: " + alphanumericDate); // Output: October 26, 2023

        String numericDate2 = "2024-03-05";
        System.out.println("Alphanumeric Date: " + convertNumericToAlphanumeric(numericDate2)); // Output: March 5, 2024

        // Example with a custom output pattern
        DateTimeFormatter customOutputFormatter = DateTimeFormatter.ofPattern("dd 'de' MMMM 'de' yyyy", new Locale("pt", "BR"));
        System.out.println("Alphanumeric Date (Portuguese): " + LocalDate.parse(numericDate, inputFormatter).format(customOutputFormatter)); // Output: 26 de outubro de 2023
    }
}
