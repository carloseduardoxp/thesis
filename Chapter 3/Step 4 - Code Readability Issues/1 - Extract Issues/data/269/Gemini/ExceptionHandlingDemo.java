import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionHandlingDemo {

    public static void main(String[] args) {
        // Example 1: Handling a potential division by zero
        System.out.println("--- Division Example ---");
        try {
            int num1 = 10;
            int num2 = 0;
            int result = num1 / num2; // This will throw an ArithmeticException
            System.out.println("Result: " + result); // This line will not be executed
        } catch (ArithmeticException e) {
            System.err.println("Error: Cannot divide by zero! " + e.getMessage());
            // e.printStackTrace(); // Uncomment to see the full stack trace
        } finally {
            System.out.println("Division attempt finished.");
        }

        System.out.println("\n--- File Reading Example ---");
        FileReader reader = null; // Declare outside try so finally can access it
        try {
            // Attempt to open a file that might not exist
            reader = new FileReader("nonExistentFile.txt");
            int charCode = reader.read(); // This will throw IOException if file doesn't exist/can't be read
            System.out.println("First character: " + (char) charCode);
        } catch (IOException e) { // Catches FileNotFoundException (which is a subclass of IOException)
            System.err.println("Error reading file: " + e.getMessage());
            // e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close(); // Ensure the file reader is closed
                    System.out.println("File reader closed.");
                } catch (IOException e) {
                    System.err.println("Error closing file reader: " + e.getMessage());
                }
            }
        }

        System.out.println("\n--- Input Mismatch Example ---");
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter an integer: ");
            int input = scanner.nextInt(); // Throws InputMismatchException if not an integer
            System.out.println("You entered: " + input);
        } catch (InputMismatchException e) {
            System.err.println("Invalid input! Please enter an integer.");
            scanner.next(); // Consume the invalid input to prevent infinite loop if used in a loop
        } finally {
            scanner.close(); // Close the scanner resource
            System.out.println("Scanner closed.");
        }

        System.out.println("\nProgram finished gracefully.");
    }
}