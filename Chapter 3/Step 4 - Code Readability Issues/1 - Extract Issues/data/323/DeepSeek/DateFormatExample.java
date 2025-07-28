import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatExample {
    public static void main(String[] args) {
        Date date = new Date();
        
        // Format date as "yyyy-MM-dd"
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sdf1.format(date)); // e.g., "2023-05-15"
        
        // Format date as "MM/dd/yyyy"
        SimpleDateFormat sdf2 = new SimpleDateFormat("MM/dd/yyyy");
        System.out.println(sdf2.format(date)); // e.g., "05/15/2023"
        
        // Format with time "yyyy-MM-dd HH:mm:ss"
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf3.format(date)); // e.g., "2023-05-15 14:30:45"
    }
}
