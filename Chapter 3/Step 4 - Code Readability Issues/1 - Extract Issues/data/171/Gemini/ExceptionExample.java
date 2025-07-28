public class ExceptionExample {
    public static void main(String[] args) {
        try {
            // Code that might throw an exception
            int result = 10 / 0; // This will throw an ArithmeticException
            System.out.println("Result: " + result); // This line will not be executed
        } catch (ArithmeticException e) {
            // Code to handle the ArithmeticException
            System.err.println("Error: Cannot divide by zero!");
            System.err.println("Exception message: " + e.getMessage());
            e.printStackTrace(); // Prints the stack trace for debugging
        } finally {
            // This block will always execute
            System.out.println("Finally block executed.");
        }
        System.out.println("Program continues after exception handling.");
    }
}
