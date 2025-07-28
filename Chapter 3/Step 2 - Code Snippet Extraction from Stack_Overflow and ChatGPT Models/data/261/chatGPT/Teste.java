
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Teste {
  public static void main(String[] args) {
    long milliseconds = System.currentTimeMillis();
    TimeZone timeZone = TimeZone.getTimeZone("America/New_York");
    Date date = new Date(milliseconds);
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    dateFormat.setTimeZone(timeZone);
    String formattedDate = dateFormat.format(date);


  }
}
