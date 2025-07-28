import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Chat {
    public static void main(String[] args) {
        ZonedDateTime zdt = ZonedDateTime.now(ZoneId.of("UTC"));
        long unixTimestamp = zdt.toEpochSecond();
        System.out.println("Unix timestamp: " + unixTimestamp);
    }
}
