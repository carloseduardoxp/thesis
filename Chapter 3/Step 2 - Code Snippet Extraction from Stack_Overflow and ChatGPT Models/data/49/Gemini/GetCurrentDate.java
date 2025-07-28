
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class GetCurrentDate {
    public static void main(String[] args) {
        // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Define the desired date format
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy", new Locale("pt", "BR"));

        // Format the current date
        String formattedDate = currentDate.format(dateFormatter);

        // Print the formatted date
        System.out.println("Current date in Brazil (Portuguese): " + formattedDate);
    }
}
