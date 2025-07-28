import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class LocalDateTimeToLongExample {
    public static void main(String[] args) {
        LocalDateTime dateTime = LocalDateTime.now();
        long millis = dateTime.toInstant(ZoneOffset.UTC).toEpochMilli();
        System.out.println(millis);
    }
}
