import java.util.Scanner; // Import the Scanner class

public class Main {
    public static void main(String[] args) {
        // Create a Scanner object to read from System.in
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter your name: ");
        String name = scanner.nextLine(); // Read a line of text
        
        System.out.print("Enter your age: ");
        int age = scanner.nextInt(); // Read an integer
        
        System.out.println("Hello " + name + ", you are " + age + " years old.");
        
        scanner.close(); // Close the scanner when done
    }
}
