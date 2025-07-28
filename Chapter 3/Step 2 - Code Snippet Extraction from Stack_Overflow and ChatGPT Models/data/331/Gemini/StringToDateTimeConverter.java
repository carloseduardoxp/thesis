import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class StringToDateTimeConverter {

    public static void main(String[] args) {

        // --- Example 1: String to LocalDate (Date only) ---
        String dateString1 = "2023-10-26";
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            LocalDate date = LocalDate.parse(dateString1, formatter1);
            System.out.println("Converted LocalDate: " + date); // Output: Converted LocalDate: 2023-10-26
        } catch (DateTimeParseException e) {
            System.err.println("Error parsing dateString1: " + e.getMessage());
        }

        // --- Example 2: String to LocalTime (Time only) ---
        String timeString1 = "14:30:00";
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm:ss");
        try {
            LocalTime time = LocalTime.parse(timeString1, formatter2);
            System.out.println("Converted LocalTime: " + time); // Output: Converted LocalTime: 14:30
        } catch (DateTimeParseException e) {
            System.err.println("Error parsing timeString1: " + e.getMessage());
        }

        // --- Example 3: String to LocalDateTime (Date and Time) ---
        String dateTimeString1 = "2023-10-26 14:30:00";
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        try {
            LocalDateTime dateTime = LocalDateTime.parse(dateTimeString1, formatter3);
            System.out.println("Converted LocalDateTime: " + dateTime); // Output: Converted LocalDateTime: 2023-10-26T14:30
        } catch (DateTimeParseException e) {
            System.err.println("Error parsing dateTimeString1: " + e.getMessage());
        }

        // --- Example 4: String to LocalDateTime with different format ---
        String dateTimeString2 = "26/10/2023 09:15 AM";
        DateTimeFormatter formatter4 = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm a");
        try {
            LocalDateTime dateTime2 = LocalDateTime.parse(dateTimeString2, formatter4);
            System.out.println("Converted LocalDateTime 2: " + dateTime2); // Output: Converted LocalDateTime 2: 2023-10-26T09:15
        } catch (DateTimeParseException e) {
            System.err.println("Error parsing dateTimeString2: " + e.getMessage());
        }

        // --- Example 5: Handling invalid date string ---
        String invalidDateString = "2023-13-01"; // Invalid month
        try {
            LocalDate invalidDate = LocalDate.parse(invalidDateString, formatter1);
            System.out.println("Converted invalidDate: " + invalidDate);
        } catch (DateTimeParseException e) {
            System.err.println("Error parsing invalidDateString: " + e.getMessage()); // Output: Error parsing invalidDateString: Text '2023-13-01' could not be parsed: Invalid value for MonthOfYear (valid values 1 - 12): 13
        }
    }
}
