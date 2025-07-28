
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Teste {

    
    public Date getData() {
        SimpleDateFormat dateFormatGmt = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");
        dateFormatGmt.setTimeZone(TimeZone.getTimeZone("GMT"));

        //Local time zone   
        SimpleDateFormat dateFormatLocal = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");

        //Time in GMT
        return dateFormatLocal.parse( dateFormatGmt.format(new Date()) );
    }
    
}