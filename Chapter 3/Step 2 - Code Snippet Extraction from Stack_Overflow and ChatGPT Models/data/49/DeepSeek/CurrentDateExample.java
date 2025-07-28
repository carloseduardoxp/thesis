import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CurrentDateExample {
    public static void main(String[] args) {
        // Current date only (without time)
        LocalDate currentDate = LocalDate.now();
        System.out.println("Current date: " + currentDate);
        
        // Current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("Current date and time: " + currentDateTime);
        
        // Formatted date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = currentDateTime.format(formatter);
        System.out.println("Formatted date and time: " + formattedDate);
    }
}
