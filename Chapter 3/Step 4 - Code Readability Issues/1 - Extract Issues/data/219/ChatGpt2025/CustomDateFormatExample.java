import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CustomDateFormatExample {
    public static void main(String[] args) {
        // Get current date-time
        LocalDateTime now = LocalDateTime.now();

        // Define custom pattern, e.g. "dd-MM-yyyy HH:mm:ss"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        // Format date-time to string
        String formattedDate = now.format(formatter);

        // Output the custom date string
        System.out.println(formattedDate);
    }
}
