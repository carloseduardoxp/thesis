
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;

public class Teste {

    public static void main(String[] args) {
        long test_timestamp = 1499070300L;
        LocalDateTime date
                = LocalDateTime.ofInstant(Instant.ofEpochMilli(test_timestamp), TimeZone
                        .getDefault().toZoneId());
    }
}
