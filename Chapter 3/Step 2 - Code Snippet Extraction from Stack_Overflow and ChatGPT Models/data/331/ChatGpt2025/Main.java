import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        String dateString = "2025-05-26 15:30:00";

        // Define the format that matches the string
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Parse the string to LocalDateTime
        LocalDateTime dateTime = LocalDateTime.parse(dateString, formatter);

        System.out.println(dateTime);
    }
}
