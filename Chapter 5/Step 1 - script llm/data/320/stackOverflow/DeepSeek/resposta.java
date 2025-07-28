import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;

public class Teste {

    public static void main(String[] args) {
        long timestamp = 1499070300L;
        LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), TimeZone
                .getDefault().toZoneId());
    }
}
