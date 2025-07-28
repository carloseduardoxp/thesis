public class LeapYearExample {
  public static void main(String[] args) {
      int year = 2022;

      boolean isLeap = false;

      // If a year is divisible by 4
      if (year % 4 == 0) {
          // and not divisible by 100
          if (year % 100 != 0) {
              isLeap = true;
          }
          // or divisible by 400
          else if (year % 400 == 0) {
              isLeap = true;
          }
      }

      if (isLeap) {
          System.out.println(year + " is a leap year.");
      } else {
          System.out.println(year + " is not a leap year.");
      }
  }
}
