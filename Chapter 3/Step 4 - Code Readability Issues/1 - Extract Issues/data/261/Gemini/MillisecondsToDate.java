import java.util.Date;

public class MillisecondsToDate {
    public static void main(String[] args) {
        long milliseconds = 1678886400000L; // Example: March 15, 2023 12:00:00 PM GMT

        Date date = new Date(milliseconds);

        System.out.println("Milliseconds: " + milliseconds);
        System.out.println("Date: " + date);
    }
}
