import java.util.Calendar;
import java.util.Date;

public class SubtractDaysExample {
    public static void main(String[] args) {
        // Create a Date object for today's date
        Date today = new Date();
        
        // Create a Calendar object and set it to today's date
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        
        // Subtract 7 days from the calendar
        calendar.add(Calendar.DAY_OF_MONTH, -7);
        
        // Get the date from the calendar
        Date sevenDaysAgo = calendar.getTime();
        
        System.out.println("Today's date: " + today);
        System.out.println("Seven days ago: " + sevenDaysAgo);
    }
}
