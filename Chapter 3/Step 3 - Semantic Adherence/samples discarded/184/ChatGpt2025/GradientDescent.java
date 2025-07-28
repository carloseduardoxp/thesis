public class GradientDescent {
    
    // Function: f(x) = (x - 3)^2
    public static double function(double x) {
        return Math.pow(x - 3, 2);
    }

    // Derivative: f'(x) = 2 * (x - 3)
    public static double derivative(double x) {
        return 2 * (x - 3);
    }

    public static void main(String[] args) {
        double x = 0;          // Initial guess
        double learningRate = 0.1;
        int iterations = 100;

        for (int i = 0; i < iterations; i++) {
            double grad = derivative(x);
            x = x - learningRate * grad;

            System.out.printf("Iteration %d: x = %.5f, f(x) = %.5f%n", i, x, function(x));
        }

        System.out.printf("Minimum found at x = %.5f with value f(x) = %.5f%n", x, function(x));
    }
}
