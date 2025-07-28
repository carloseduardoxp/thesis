
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Hw2JamesVaughn {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Prompt user for month and year
        System.out.print("Please enter the month and year: ");
        int year = input.nextInt();

        GregorianCalendar cal = new GregorianCalendar();

        if (cal.isLeapYear(year)) {
            System.out.print("Given year is leap year.");
        } else {
            System.out.print("Given year is not leap year.");
        }
    }
}
