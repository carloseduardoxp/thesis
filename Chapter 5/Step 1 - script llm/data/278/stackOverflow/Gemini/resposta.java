public class Teste {

    public static void main(String[] args) {        
        DateTime dateTimeUtc = new DateTime(); //because my default timezone is UTC
        DateTime dateTimeBerlin = dateTimeUtc.withZone(DateTimeZone.forID("Europe/Berlin"));
    }
}
