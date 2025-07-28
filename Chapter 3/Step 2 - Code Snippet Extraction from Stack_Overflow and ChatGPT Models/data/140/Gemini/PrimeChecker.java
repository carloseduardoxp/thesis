public class PrimeChecker {

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false; // Numbers less than or equal to 1 are not prime
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false; // Found a divisor, so it's not prime
            }
        }
        return true; // No divisors found, so it's prime
    }

    public static void main(String[] args) {
        System.out.println("7 is prime: " + isPrime(7));     // true
        System.out.println("10 is prime: " + isPrime(10));   // false
        System.out.println("1 is prime: " + isPrime(1));     // false
        System.out.println("2 is prime: " + isPrime(2));     // true
        System.out.println("29 is prime: " + isPrime(29));   // true
    }
}
