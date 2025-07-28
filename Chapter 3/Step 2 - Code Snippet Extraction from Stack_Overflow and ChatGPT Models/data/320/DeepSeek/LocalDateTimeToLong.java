import java.time.*;

public class LocalDateTimeToLong {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        
        // Convert to milliseconds since epoch (UTC)
        long milliseconds = localDateTime.atZone(ZoneId.systemDefault())
                                        .toInstant()
                                        .toEpochMilli();
        
        System.out.println("Milliseconds since epoch: " + milliseconds);
    }
}
