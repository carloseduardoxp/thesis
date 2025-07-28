import java.text.SimpleDateFormat;
import java.util.Date;

public class NumericToAlphanumericDateExample {
    public static void main(String[] args) {
        String numericDate = "20220401"; // numeric date in format yyyyMMdd
        try {
            SimpleDateFormat numericFormat = new SimpleDateFormat("yyyyMMdd");
            Date date = numericFormat.parse(numericDate);

            SimpleDateFormat alphanumericFormat = new SimpleDateFormat("MMM dd, yyyy");
            String alphanumericDate = alphanumericFormat.format(date);

            System.out.println("Numeric date: " + numericDate);
            System.out.println("Alphanumeric date: " + alphanumericDate);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
