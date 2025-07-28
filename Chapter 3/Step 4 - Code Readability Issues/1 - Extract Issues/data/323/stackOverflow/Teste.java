
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Teste {

    public static void main(String[] args) {        
        Format formatter = new SimpleDateFormat("yyyy-MM-dd");
        Calendar now = Calendar.getInstance();
        System.out.println("Now: "+formatter.format(now.getTime()) );
    }
}