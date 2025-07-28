import org.joda.time.DateTime;
import java.util.Date;

public class DateTimeToDateConverter {
    public static void main(String[] args) {
        DateTime dateTime = new DateTime(); // current date and time
        
        Date date = dateTime.toDate(); // convert to date
        
        System.out.println("DateTime: " + dateTime);
        System.out.println("Date: " + date);
    }
}
