import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Teste {

    public static void main(String[] args) {
        String str = "12/9/2010 4:39:38 PM";

        DateFormat formatter;

        Date date;

        formatter = new SimpleDateFormat("M/dd/yyyy H:m:s a");

        date = formatter.parse(str);

        System.out.println("date printed " + formatter.format(date));
    }
}
