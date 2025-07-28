import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFromStringExample {
    public static void main(String[] args) {
        String dateString = "2023-04-02";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date;

        try {
            date = dateFormat.parse(dateString);
            System.out.println(date);
        } catch (ParseException e) {
            System.out.println("Invalid date format");
        }
    }
}
