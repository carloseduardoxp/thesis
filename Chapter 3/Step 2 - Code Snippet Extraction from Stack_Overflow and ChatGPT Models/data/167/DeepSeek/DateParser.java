import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParser {
    public static void main(String[] args) throws Exception {
        String dateString = "2023-05-15";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = formatter.parse(dateString);
        System.out.println(date);
    }
}
