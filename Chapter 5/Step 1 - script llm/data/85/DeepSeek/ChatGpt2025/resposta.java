import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {
    public static void main(String[] args) throws Exception {
        String numericDate = "2023-12-25";
        
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat outputFormat = new SimpleDateFormat("MMMM dd, yyyy");
        
        Date date = inputFormat.parse(numericDate);
        String alphanumericDate = outputFormat.format(date);
        
        System.out.println(alphanumericDate); // Output: December 25, 2023
    }
}
