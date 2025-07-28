import java.util.Scanner;

public class ReadStdin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter some input:");
        
        // Read a line
        String line = scanner.nextLine();
        System.out.println("You entered: " + line);
        
        // Read different types
        System.out.println("Enter an integer:");
        int num = scanner.nextInt();
        System.out.println("You entered: " + num);
        
        scanner.close(); // Don't forget to close the scanner
    }
}
