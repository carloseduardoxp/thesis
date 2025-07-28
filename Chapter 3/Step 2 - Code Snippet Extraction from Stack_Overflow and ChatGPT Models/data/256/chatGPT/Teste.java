public class Teste {
  public static void main(String[] args) {
    long currentTimeMillis = System.currentTimeMillis();
    System.out.println("Time since epoch (milliseconds): " + currentTimeMillis);

    long secondsSinceEpoch = currentTimeMillis / 1000L;
    System.out.println("Time since epoch (seconds): " + secondsSinceEpoch);

    long minutesSinceEpoch = secondsSinceEpoch / 60L;
    System.out.println("Time since epoch (minutes): " + minutesSinceEpoch);

    long hoursSinceEpoch = minutesSinceEpoch / 60L;
    System.out.println("Time since epoch (hours): " + hoursSinceEpoch);

    long daysSinceEpoch = hoursSinceEpoch / 24L;
    System.out.println("Time since epoch (days): " + daysSinceEpoch);

  }
}
