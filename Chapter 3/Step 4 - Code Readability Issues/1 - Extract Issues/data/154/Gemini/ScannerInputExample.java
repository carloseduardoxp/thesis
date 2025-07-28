import java.util.Scanner; // Don't forget to import!

public class ScannerInputExample {
    public static void main(String[] args) {
        // 1. Create a Scanner object for console input
        Scanner scanner = new Scanner(System.in);

        // 2. Read an integer
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        System.out.println("You are " + age + " years old.");

        // IMPORTANT: Consume the rest of the current line after nextInt(), nextDouble(), etc.
        // This is crucial before calling nextLine() to avoid skipping input.
        scanner.nextLine(); // Consume the newline character left by nextInt()

        // 3. Read a string (single word)
        System.out.print("Enter your first name: ");
        String firstName = scanner.next();
        System.out.println("Hello, " + firstName + "!");

        // 4. Read a full line of text
        scanner.nextLine(); // Consume the newline character left by next() (if any)
        System.out.print("Enter your full address: ");
        String address = scanner.nextLine();
        System.out.println("Your address is: " + address);

        // 5. Read a double
        System.out.print("Enter your GPA: ");
        double gpa = scanner.nextDouble();
        System.out.println("Your GPA is: " + gpa);

        // 6. Read a boolean
        System.out.print("Are you a student? (true/false): ");
        boolean isStudent = scanner.nextBoolean();
        System.out.println("Student status: " + isStudent);

        // 7. Close the scanner
        scanner.close();
        System.out.println("Scanner closed.");
    }
}
