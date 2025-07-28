import java.util.Calendar;

public class Teste {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        Long max = calendar.getTimeInMillis();
        int currMonth = calendar.get(Calendar.MONTH);
        int currDate = calendar.get(Calendar.DAY_OF_MONTH);
        int expMonth = currMonth + 3/*no_of_month*/;
        int expYear = currDate;
        int expDate = calendar.get(Calendar.DAY_OF_MONTH);
        while (expMonth > 11) {
            expMonth = expMonth - 12;
            expYear = expYear + 1; // will increment year as next month falls in next year 
        }
        calendar.set(expYear, expMonth, expDate);
        Long min = calendar.getTimeInMillis();
        Long range = (max - min) / (60 * 60 * 1000); //no_of_hours
    }

}
