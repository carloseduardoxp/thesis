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
        } finally {
            System.out.println("Division attempt finished.");
        }

        System.out.println("\n--- File Reading Example ---");
        // Using try-with-resources to automatically close the FileReader
        try (FileReader reader = new FileReader("nonExistentFile.txt")) {
            // Attempt to open a file that might not exist
            int charCode = reader.read(); // This will throw IOException if file doesn't exist/can't be read
            System.out.println("First character: " + (char) charCode);
        } catch (IOException e) { // Catches FileNotFoundException (which is a subclass of IOException)
            System.err.println("Error reading file: " + e.getMessage());
        }
        // The FileReader is automatically closed by the try-with-resources statement.
        System.out.println("File reader resource managed by try-with-resources.");


        System.out.println("\n--- Input Mismatch Example ---");
        // Using try-with-resources to automatically close the Scanner
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter an integer: ");
            int input = scanner.nextInt(); // Throws InputMismatchException if not an integer
            System.out.println("You entered: " + input);
        } catch (InputMismatchException e) {
            System.err.println("Invalid input! Please enter an integer.");
            // In a loop, you would typically consume the invalid token here.
            // Since the scanner is closed by try-with-resources, it's not needed for this example.
        }
        // The Scanner is automatically closed by the try-with-resources statement.
        System.out.println("Scanner closed automatically.");


        System.out.println("\nProgram finished gracefully.");
    }
}
