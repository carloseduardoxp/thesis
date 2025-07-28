import java.time.Instant;

public class InstantFromMillis {
    public static void main(String[] args) {
        long epochMilli = 1678886400000L; // Example: March 15, 2023 12:00:00 PM UTC

        Instant instant = Instant.ofEpochMilli(epochMilli);
        System.out.println("Instant from milliseconds: " + instant);

        // Get the current Instant in milliseconds
        long currentEpochMilli = Instant.now().toEpochMilli();
        System.out.println("Current Instant in milliseconds: " + currentEpochMilli);
        Instant currentInstant = Instant.ofEpochMilli(currentEpochMilli);
        System.out.println("Current Instant from milliseconds: " + currentInstant);
    }
}
