import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class TimezoneConversion {
    public static void main(String[] args) {
        // Current date-time in a specific timezone
        ZonedDateTime dateTimeInUTC = ZonedDateTime.now(ZoneId.of("UTC"));
        System.out.println("Original time (UTC): " + dateTimeInUTC.format(DateTimeFormatter.ISO_ZONED_DATE_TIME));

        // Convert to another timezone, for example, America/New_York
        ZonedDateTime dateTimeInNY = dateTimeInUTC.withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println("Converted time (New York): " + dateTimeInNY.format(DateTimeFormatter.ISO_ZONED_DATE_TIME));
    }
}
