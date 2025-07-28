import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StringToDateTimeExample {
    public static void main(String[] args) {
        String dateString = "2022-04-05T13:30:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(dateString, formatter);

        System.out.println(dateTime);
    }
}
