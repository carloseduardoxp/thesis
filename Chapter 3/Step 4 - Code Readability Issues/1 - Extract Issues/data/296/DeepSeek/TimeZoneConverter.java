import java.time.*;
import java.time.format.DateTimeFormatter;

public class TimeZoneConverter {
    public static void main(String[] args) {
        // Current time in system default timezone
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println("Current time (default zone): " + now);
        
        // Convert to another timezone
        ZoneId newYorkZone = ZoneId.of("America/New_York");
        ZonedDateTime newYorkTime = now.withZoneSameInstant(newYorkZone);
        System.out.println("New York time: " + newYorkTime);
        
        // Formatting with timezone
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");
        System.out.println("Formatted NY time: " + newYorkTime.format(formatter));
        
        // Convert between zones directly
        ZoneId tokyoZone = ZoneId.of("Asia/Tokyo");
        ZonedDateTime tokyoTime = newYorkTime.withZoneSameInstant(tokyoZone);
        System.out.println("Tokyo time: " + tokyoTime.format(formatter));
    }
}
