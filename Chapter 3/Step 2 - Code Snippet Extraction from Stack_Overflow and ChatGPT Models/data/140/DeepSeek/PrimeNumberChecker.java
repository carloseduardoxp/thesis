import java.util.Scanner;

public class PrimeNumberChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number to check if it's prime: ");
        int number = scanner.nextInt();
        
        if (isPrime(number)) {
            System.out.println(number + " is a prime number.");
        } else {
            System.out.println(number + " is not a prime number.");
        }
    }
    
    public static boolean isPrime(int num) {
        // 0, 1, and negative numbers are not prime
        if (num <= 1) {
            return false;
        }
        
        // 2 is the only even prime number
        if (num == 2) {
            return true;
        }
        
        // Any even number other than 2 is not prime
        if (num % 2 == 0) {
            return false;
        }
        
        // Check for divisors up to the square root of the number
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}
