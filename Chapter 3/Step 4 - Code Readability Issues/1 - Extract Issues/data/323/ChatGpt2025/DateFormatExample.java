import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatExample {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now(); // current date

        // Define a formatter with the desired pattern
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Format the date to a string
        String formattedDate = date.format(formatter);

        System.out.println("Formatted date: " + formattedDate);
    }
}
