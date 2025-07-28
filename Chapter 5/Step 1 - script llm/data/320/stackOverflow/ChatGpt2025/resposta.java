import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;

public class Teste {

    public static void main(String[] args) {
        long testTimestamp = 1499070300L;
        LocalDateTime.ofInstant(Instant.ofEpochMilli(testTimestamp), TimeZone.getDefault().toZoneId());
    }
}