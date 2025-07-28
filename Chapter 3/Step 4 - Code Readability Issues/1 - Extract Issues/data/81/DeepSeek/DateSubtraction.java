import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateSubtraction {
    public static void main(String[] args) {
        // Current date
        LocalDate today = LocalDate.now();
        System.out.println("Today: " + today);
        
        // Subtract 5 days
        LocalDate fiveDaysAgo = today.minusDays(5);
        System.out.println("Five days ago: " + fiveDaysAgo);
        
        // Subtract days from a specific date
        LocalDate specificDate = LocalDate.of(2023, 5, 15);
        LocalDate result = specificDate.minusDays(10);
        System.out.println("10 days before May 15, 2023: " + result);
        
        // Formatting the output
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println("Formatted date: " + result.format(formatter));
    }
}
