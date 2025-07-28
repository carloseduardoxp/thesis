
public class ExceptionHandlingExample {
    public static void main(String[] args) {
        try {
            int result = 10 / 0; // This will throw an ArithmeticException
            System.out.println("Result: " + result); // This line will not be executed
        } catch (ArithmeticException e) {
            System.err.println("Error: Cannot divide by zero!");
            System.err.println("Exception message: " + e.getMessage());
            // You can also log the exception for debugging: e.printStackTrace();
        } finally {
            System.out.println("This finally block always executes.");
        }

        System.out.println("Program continues after exception handling.");

        try {
            String str = null;
            System.out.println(str.length()); // This will throw a NullPointerException
        } catch (NullPointerException e) {
            System.err.println("Error: Null pointer encountered!");
        }

        // Using try-with-resources for automatic resource closing (Java 7+)
        try (java.io.FileReader reader = new java.io.FileReader("nonexistent.txt")) {
            // Code that uses the reader
            System.out.println("File read successfully.");
        } catch (java.io.FileNotFoundException e) {
            System.err.println("Error: File not found: " + e.getMessage());
        } catch (java.io.IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
