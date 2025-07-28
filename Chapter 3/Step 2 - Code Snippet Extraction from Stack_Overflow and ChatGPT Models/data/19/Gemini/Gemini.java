import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class Gemini {
    public static long toUnixTimestamp(LocalDateTime dateTime) {
        return dateTime.toEpochSecond(ZoneOffset.UTC);
    }

    public static void main(String[] args) {
        // Example usage:
        LocalDateTime now = LocalDateTime.now();
        long unixTimestamp = toUnixTimestamp(now);
        System.out.println("Current DateTime: " + now);
        System.out.println("Unix Timestamp: " + unixTimestamp);

        LocalDateTime specificDateTime = LocalDateTime.of(2025, 5, 12, 10, 0, 0); // Example: May 12, 2025 10:00:00
        long specificUnixTimestamp = toUnixTimestamp(specificDateTime);
        System.out.println("Specific DateTime: " + specificDateTime);
        System.out.println("Unix Timestamp: " + specificUnixTimestamp);
    }
}
