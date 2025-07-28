import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class DeepSeek {
    public static void main(String[] args) {
        // Current time to Unix timestamp
        long unixTimestamp = Instant.now().getEpochSecond();
        System.out.println("Current Unix timestamp: " + unixTimestamp);
        
        // Specific date/time to Unix timestamp
        LocalDateTime dateTime = LocalDateTime.of(2023, 5, 15, 12, 30);
        long specificTimestamp = dateTime.atZone(ZoneId.systemDefault()).toEpochSecond();
        System.out.println("Specific date timestamp: " + specificTimestamp);
    }
}
