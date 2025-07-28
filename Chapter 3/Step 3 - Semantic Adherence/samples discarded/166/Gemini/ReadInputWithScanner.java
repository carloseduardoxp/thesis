import java.util.Scanner;

public class ReadInputWithScanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object

        System.out.print("Enter your name: ");
        String name = scanner.nextLine(); // Read a whole line (including spaces)
        System.out.println("Hello, " + name + "!");

        System.out.print("Enter your age: ");
        int age = scanner.nextInt(); // Read an integer
        System.out.println("You are " + age + " years old.");

        System.out.print("Enter your favorite number (decimal): ");
        double favNumber = scanner.nextDouble(); // Read a double
        System.out.println("Your favorite number is: " + favNumber);

        // Important: Consume the rest of the line after nextInt() or nextDouble()
        // if you plan to use nextLine() immediately afterward.
        scanner.nextLine(); // Consume the newline character left by nextInt/nextDouble

        System.out.print("Tell me something interesting: ");
        String interestingFact = scanner.nextLine(); // Read another line
        System.out.println("Interesting fact: " + interestingFact);


        scanner.close(); // Close the scanner when you're done with it
    }
}
