import java.time.LocalDate;
import java.time.LocalDateTime;

public class DateTimeToDate {

    public static void main(String[] args) {
        // 1. Get a LocalDateTime instance
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("Current LocalDateTime: " + currentDateTime);

        // 2. Convert LocalDateTime to LocalDate
        LocalDate date = currentDateTime.toLocalDate();
        System.out.println("Converted LocalDate: " + date);

        // Example with a specific LocalDateTime
        LocalDateTime specificDateTime = LocalDateTime.of(2023, 10, 26, 15, 30, 45);
        System.out.println("Specific LocalDateTime: " + specificDateTime);
        LocalDate specificDate = specificDateTime.toLocalDate();
        System.out.println("Converted Specific LocalDate: " + specificDate);
    }
}
