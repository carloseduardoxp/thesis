import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TimeZoneConversion {
    public static void main(String[] args) {
        // 1. Define a LocalDateTime (e.g., a meeting scheduled at 10:00 AM)
        LocalDateTime localDateTime = LocalDateTime.of(2025, 12, 25, 10, 0, 0);
        System.out.println("Local Date Time (no zone): " + localDateTime);

        // 2. Define the source ZoneId (where this local date time is applicable)
        ZoneId newYorkZone = ZoneId.of("America/New_York");

        // 3. Create a ZonedDateTime by combining LocalDateTime and ZoneId
        ZonedDateTime newYorkDateTime = localDateTime.atZone(newYorkZone);
        System.out.println("New York Time: " + newYorkDateTime);
    }
}
