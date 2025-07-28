
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Teste {
  public static void main(String[] args) {
    // Create a DateTimeFormatter object to parse the input date string
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    // Parse the input date string into a LocalDateTime object
    LocalDateTime localDateTime = LocalDateTime.parse("2023-04-04 15:30:00", formatter);

    // Specify the timezone of the input date/time
    ZoneId inputTimeZone = ZoneId.of("Asia/Kolkata");

    // Specify the timezone to which you want to convert the date/time
    ZoneId outputTimeZone = ZoneId.of("America/New_York");

    // Convert the input date/time to the output timezone
    ZonedDateTime inputZonedDateTime = localDateTime.atZone(inputTimeZone);
    ZonedDateTime outputZonedDateTime = inputZonedDateTime.withZoneSameInstant(outputTimeZone);

    // Format the output date/time as a string
    String outputDateTimeString = outputZonedDateTime.format(formatter);

    // Print the output date/time string
    System.out.println(outputDateTimeString);
    
  }
}
