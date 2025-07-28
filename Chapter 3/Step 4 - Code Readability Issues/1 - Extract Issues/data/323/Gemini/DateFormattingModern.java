import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime; // For time zones
import java.time.format.DateTimeFormatter;

public class DateFormattingModern {

    public static void main(String[] args) {
        // Get current date and time
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Current LocalDateTime: " + now);

        // --- Custom Formatting ---
        // Define a custom pattern
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate1 = now.format(formatter1);
        System.out.println("Formatted Date (yyyy-MM-dd HH:mm:ss): " + formattedDate1);

        // Another custom pattern
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy EEEE, hh:mm a");
        String formattedDate2 = now.format(formatter2);
        System.out.println("Formatted Date (dd/MM/yyyy EEEE, hh:mm a): " + formattedDate2);

        // --- Formatting with Time Zones (if needed) ---
        ZonedDateTime zonedNow = ZonedDateTime.now(); // Gets current date/time with default system time zone
        System.out.println("Current ZonedDateTime: " + zonedNow);

        // Format with time zone abbreviation
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");
        String formattedDate3 = zonedNow.format(formatter3);
        System.out.println("Formatted Date with time zone: " + formattedDate3);

        // Format for a specific time zone
        ZonedDateTime saoPauloTime = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));
        DateTimeFormatter formatter4 = DateTimeFormatter.ofPattern("dd MMM yyyy, HH:mm:ss zzz");
        String formattedDate4 = saoPauloTime.format(formatter4);
        System.out.println("Formatted Date in Sao Paulo time: " + formattedDate4);

        // --- Predefined Formatters ---
        // ISO_LOCAL_DATE (e.g., 2024-12-25)
        String isoLocalDate = now.format(DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println("ISO Local Date: " + isoLocalDate);

        // ISO_LOCAL_DATE_TIME (e.g., 2024-12-25T10:30:00)
        String isoLocalDateTime = now.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        System.out.println("ISO Local Date Time: " + isoLocalDateTime);
    }
}
