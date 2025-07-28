import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StringToDateTime {
    public static void main(String[] args) {
        // String to LocalDate
        String dateStr = "2023-05-15";
        LocalDate date = LocalDate.parse(dateStr);
        System.out.println("LocalDate: " + date);
        
        // String to LocalDateTime with custom format
        String dateTimeStr = "15-05-2023 14:30:45";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr, formatter);
        System.out.println("LocalDateTime: " + dateTime);
    }
}
