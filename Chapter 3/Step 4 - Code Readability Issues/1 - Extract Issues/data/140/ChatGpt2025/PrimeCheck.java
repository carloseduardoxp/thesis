public class PrimeCheck {

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false; // numbers less than or equal to 1 are not prime
        }
        // check divisibility from 2 up to sqrt(num)
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false; // divisible by i means not prime
            }
        }
        return true; // no divisors found, it is prime
    }

    public static void main(String[] args) {
        int number = 29; // change this number to test other values
        if (isPrime(number)) {
            System.out.println(number + " is prime.");
        } else {
            System.out.println(number + " is not prime.");
        }
    }
}
