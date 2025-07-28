import java.util.Scanner;

public class ScannerExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create Scanner object

        // Read a string
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        // Read an integer
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        // Read a double
        System.out.print("Enter your height: ");
        double height = scanner.nextDouble();

        // Output the collected data
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Height: " + height);

        scanner.close(); // Close the scanner
    }
}
