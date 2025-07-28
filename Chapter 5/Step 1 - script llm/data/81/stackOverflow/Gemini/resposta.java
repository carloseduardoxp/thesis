import java.util.Calendar;

public class Teste {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        int currMonth = calendar.get(Calendar.MONTH);
        int expMonth = currMonth + 3/*no_of_month*/;
        int expYear = calendar.get(Calendar.YEAR);
        int expDate = calendar.get(Calendar.DAY_OF_MONTH);
        while (expMonth > 11) {
            expMonth = expMonth - 12;
            expYear = expYear + 1; // will increment year as next month falls in next year
        }
        calendar.set(expYear, expMonth, expDate);
    }

}
