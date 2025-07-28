import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale; // For locale-specific formatting

public class LegacyDateFormatting {

    public static void main(String[] args) {
        Date currentDate = new Date(); // Represents the current date and time

        // Example 1: Common date and time format
        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate1 = formatter1.format(currentDate);
        System.out.println("Format 1 (yyyy-MM-dd HH:mm:ss): " + formattedDate1);

        // Example 2: Month name, day, year, and AM/PM time
        SimpleDateFormat formatter2 = new SimpleDateFormat("MMMM dd, yyyy 'at' hh:mm a");
        String formattedDate2 = formatter2.format(currentDate);
        System.out.println("Format 2 (MMMM dd, yyyy 'at' hh:mm a): " + formattedDate2);

        // Example 3: Day of week, day, month abbreviation, year, and time zone
        SimpleDateFormat formatter3 = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss z");
        String formattedDate3 = formatter3.format(currentDate);
        System.out.println("Format 3 (EEE, d MMM yyyy HH:mm:ss z): " + formattedDate3);

        // Example 4: Custom format with a specific locale (e.g., French)
        SimpleDateFormat formatter4 = new SimpleDateFormat("EEEE d MMMM yyyy", Locale.FRANCE);
        String formattedDate4 = formatter4.format(currentDate);
        System.out.println("Format 4 (French locale): " + formattedDate4);

        // Example 5: Date only
        SimpleDateFormat formatter5 = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate5 = formatter5.format(currentDate);
        System.out.println("Format 5 (dd/MM/yyyy): " + formattedDate5);
    }
}
