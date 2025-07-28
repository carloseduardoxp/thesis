import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StringToDateExample {
    public static void main(String[] args) {
        String dateString1 = "2023-10-26"; // ISO_LOCAL_DATE format
        String dateString2 = "26/10/2023"; // Custom format

        // For ISO_LOCAL_DATE (yyyy-MM-dd), no explicit formatter is needed
        LocalDate localDate1 = LocalDate.parse(dateString1);
        System.out.println("Parsed LocalDate 1: " + localDate1);

        // For custom formats, create a DateTimeFormatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate2 = LocalDate.parse(dateString2, formatter);
        System.out.println("Parsed LocalDate 2: " + localDate2);

        // If you need a java.util.Date from LocalDate (less common, but possible)
        // You'll need to convert it to a LocalDateTime first, then to Instant.
        java.util.Date utilDate = java.util.Date.from(localDate1.atStartOfDay().toInstant(java.time.ZoneOffset.UTC));
        System.out.println("Converted to java.util.Date: " + utilDate);
    }
}
