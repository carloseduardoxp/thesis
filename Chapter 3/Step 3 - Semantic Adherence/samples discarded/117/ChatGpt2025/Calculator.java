public class Calculator {

    // Method that adds two integers and returns the sum
    public int add(int a, int b) {
        int sum = a + b;
        return sum;
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        int result = calc.add(5, 3);
        System.out.println("Sum: " + result);  // Output: Sum: 8
    }
}
