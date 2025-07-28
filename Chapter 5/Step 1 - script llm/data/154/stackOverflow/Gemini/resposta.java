import java.util.Scanner;

public class Teste {

    public static void main(String[] args) {
        System.out.println("Enter your username: ");
        try (Scanner scan = new Scanner(System.in)) {
            // The input is read but not used, resolving the warning
            // while preserving the program's behavior of waiting for input.
            scan.nextLine();
        }
    }
}
