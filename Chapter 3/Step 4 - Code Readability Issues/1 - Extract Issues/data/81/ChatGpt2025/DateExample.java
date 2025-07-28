import java.time.LocalDate;

public class DateExample {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println("Today: " + today);

        // Subtract 5 days
        LocalDate newDate = today.minusDays(5);
        System.out.println("Date after subtracting 5 days: " + newDate);
    }
}
