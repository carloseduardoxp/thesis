import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {
    public static void main(String[] args) throws Exception {
        String numericDate = "2023-12-25"; // or "12/25/2023"
        
        // For format "yyyy-MM-dd"
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
        // For format "MM/dd/yyyy" use:
        
        SimpleDateFormat outputFormat = new SimpleDateFormat("MMMM dd, yyyy");
        
        Date date = inputFormat.parse(numericDate);
        String alphanumericDate = outputFormat.format(date);
        
        System.out.println(alphanumericDate); // Output: December 25, 2023
    }
}
