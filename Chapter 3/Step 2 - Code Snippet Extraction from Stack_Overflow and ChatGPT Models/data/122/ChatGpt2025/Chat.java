
import java.time.Instant;

public class Chat {

    public static void main(String[] args) {

        long timestampMillis = 1684600000000L; // example timestamp in milliseconds
        Instant instant = Instant.ofEpochMilli(timestampMillis);
        System.out.println(instant);

    }

}
