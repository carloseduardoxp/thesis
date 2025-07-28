import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class Teste {
    public static void main(String[] args) {
        // Create a LocalDateTime object representing the date and time you want to convert
        LocalDateTime datetime = LocalDateTime.now();
        
        // Convert the LocalDateTime object to a Unix timestamp
        long unixTimestamp = datetime.toEpochSecond(ZoneOffset.UTC);
        
        // Print the Unix timestamp
        System.out.println("Unix timestamp: " + unixTimestamp);
    }
}
