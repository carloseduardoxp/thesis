import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        String input = "The event will be on 2025-05-22.";
        String dateStr = "2025-05-22"; // extract this part beforehand
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateStr, formatter);
        
        System.out.println("Parsed date: " + date);
    }
}
