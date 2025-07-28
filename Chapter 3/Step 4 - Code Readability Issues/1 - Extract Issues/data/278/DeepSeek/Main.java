import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // java.util.Date already contains both date and time
        Date dateTime = new Date(); // current date and time
        
        // To get just the date part (time set to 00:00:00)
        @SuppressWarnings("deprecation")
        Date justDate = new Date(dateTime.getYear(), dateTime.getMonth(), dateTime.getDate());
        
        System.out.println("DateTime: " + dateTime);
        System.out.println("Just Date: " + justDate);
    }
}
