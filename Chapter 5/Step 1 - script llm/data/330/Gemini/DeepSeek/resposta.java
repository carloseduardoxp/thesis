public class LeapYear {

    public static boolean isLeapYear(int year) {
        // Rule 1: Divisible by 4
        if (year % 4 == 0) {
            // Rule 2 & 3: Divisible by 100 but not by 400
            if (year % 100 == 0) {
                return year % 400 == 0; // Divisible by 400, so it's a leap year, otherwise not
            } else {
                return true; // Divisible by 4 but not by 100, so it's a leap year
            }
        } else {
            return false; // Not divisible by 4, so not a leap year
        }
    }

    // A more concise way to write the same logic
    public static boolean isLeapYearConcise(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static void main(String[] args) {
        System.out.println("Is 2000 a leap year? " + isLeapYear(2000)); // true
        System.out.println("Is 2004 a leap year? " + isLeapYear(2004)); // true
        System.out.println("Is 1900 a leap year? " + isLeapYear(1900)); // false
        System.out.println("Is 2023 a leap year? " + isLeapYear(2023)); // false
        System.out.println("Is 2024 a leap year? " + isLeapYear(2024)); // true

        System.out.println("\nUsing concise method:");
        System.out.println("Is 2000 a leap year? " + isLeapYearConcise(2000)); // true
        System.out.println("Is 2004 a leap year? " + isLeapYearConcise(2004)); // true
        System.out.println("Is 1900 a leap year? " + isLeapYearConcise(1900)); // false
        System.out.println("Is 2023 a leap year? " + isLeapYearConcise(2023)); // false
        System.out.println("Is 2024 a leap year? " + isLeapYearConcise(2024)); // true
    }
}
