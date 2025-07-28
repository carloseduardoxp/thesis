
import java.time.Instant;

public class Teste {
  public static void main(String[] args) {
    long timestampInMillis = 1617384459000L; // timestamp in milliseconds
    Instant instant = Instant.ofEpochMilli(timestampInMillis);
    System.out.println(instant); // Output: 2021-04-02T11:14:19Z

    long timestampInSeconds1 = 1617384459L; // timestamp in seconds
    Instant instant1 = Instant.ofEpochSecond(timestampInSeconds1);
    System.out.println(instant1); // Output: 2021-04-02T11:14:19Z


  }
}
