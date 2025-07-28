import java.time.LocalDate;

public class DateSubtraction {
    public static void main(String[] args) {
        // Get the current date
        LocalDate today = LocalDate.now();
        System.out.println("Today: " + today); // Example: 2025-05-20

        // Subtract 7 days
        LocalDate sevenDaysAgo = today.minusDays(7);
        System.out.println("7 days ago: " + sevenDaysAgo); // Example: 2025-05-13

        // Subtract a specific number of days (e.g., 30 days)
        LocalDate thirtyDaysAgo = today.minusDays(30);
        System.out.println("30 days ago: " + thirtyDaysAgo); // Example: 2025-04-20

        // You can also chain operations
        LocalDate aMonthAndAWeekAgo = today.minusMonths(1).minusWeeks(1);
        System.out.println("A month and a week ago: " + aMonthAndAWeekAgo);
    }
}
