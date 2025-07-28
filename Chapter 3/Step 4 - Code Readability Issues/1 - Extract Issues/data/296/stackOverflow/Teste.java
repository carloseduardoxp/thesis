
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Teste {

    public static void main(String[] args) {        
        String strDate = "2015-08-21 03:15";
        String timeZone="GMT+05:30";
        String format = "yyyy-MM-dd HH:mmz";
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        Date dateStr = formatter.parse(strDate+timeZone);
        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
        String formattedDate = formatter.format(dateStr);
        System.out.println("UTC datetime is: "+formattedDate);
    }
}