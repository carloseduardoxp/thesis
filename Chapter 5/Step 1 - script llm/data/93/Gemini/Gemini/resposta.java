public class Fibonacci {

    private static final String FIBONACCI_OUTPUT_PREFIX = "Fibonacci (iterative) for n = ";

    public static int fibonacciIterative(int n) {
        if (n <= 1) {
            return n;
        }

        int a = 0; // Represents F(n-2)
        int b = 1; // Represents F(n-1)
        int result = 0; // Represents F(n)

        for (int i = 2; i <= n; i++) {
            result = a + b; // Calculate F(n)
            a = b;           // Update a to be the previous b
            b = result;      // Update b to be the newly calculated result
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 10; // Calculate the 10th Fibonacci number (F(10))
        System.out.println(FIBONACCI_OUTPUT_PREFIX + n + ": " + fibonacciIterative(n)); // Output: 55

        n = 0;
        System.out.println(FIBONACCI_OUTPUT_PREFIX + n + ": " + fibonacciIterative(n)); // Output: 0

        n = 1;
        System.out.println(FIBONACCI_OUTPUT_PREFIX + n + ": " + fibonacciIterative(n)); // Output: 1

        n = 2;
        System.out.println(FIBONACCI_OUTPUT_PREFIX + n + ": " + fibonacciIterative(n)); // Output: 1
    }
}
