
import java.text.SimpleDateFormat;
import java.util.Date;

public class Teste {

    public static void main(String[] args) {        
        String time = "2012-12-08 13:39:57 +0000";

        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z").parse(time);
        String str = new SimpleDateFormat("dd MMM yyyy HH:mm:ss").format(date);
        
        System.out.println(str);
    }
}