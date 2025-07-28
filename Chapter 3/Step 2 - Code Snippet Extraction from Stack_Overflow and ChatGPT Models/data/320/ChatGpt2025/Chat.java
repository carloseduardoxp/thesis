
import java.time.LocalDateTime;
import java.time.ZoneId;

public class Chat {

    public static void main(String[] args) {

        LocalDateTime localDateTime = LocalDateTime.now();
        ZoneId zoneId = ZoneId.systemDefault(); // ou ZoneId.of("UTC")

        long millis = localDateTime.atZone(zoneId).toInstant().toEpochMilli();
        System.out.println("Epoch millis: " + millis);

    }

}
