
import java.util.Scanner;

public class Teste {

    public static void main(String[] args) {

        System.out.print("Enter a number: ");
        Scanner key = new Scanner(System.in);
        int in = key.nextInt();

        isPrimeNumber(in);
    }

    static boolean isPrimeNumber(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
