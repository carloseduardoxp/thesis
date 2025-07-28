import java.util.Scanner;

public class Teste {

     public static void main(final String[] args) {
        System.out.println("Your number? ");
        final Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            final int check = sc.nextInt();
            System.out.println("OKEI " + check + " IT IS INTEGER! ");
        } else if (sc.hasNextDouble()) {
            final double check = sc.nextDouble();
            System.out.println("Nooo " + check + " NO it is not INT");
        } else {
            System.out.println("Failed.");
        }
  }
   
}