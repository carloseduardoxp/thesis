import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter your name:");

        String name = scanner.nextLine();  // Read a line of input
        System.out.println("Hello, " + name + "!");
    }
}
