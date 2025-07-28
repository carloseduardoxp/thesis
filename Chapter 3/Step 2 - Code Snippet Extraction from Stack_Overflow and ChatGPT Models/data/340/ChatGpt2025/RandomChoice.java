import java.util.Random;

public class RandomChoice {
    public static void main(String[] args) {
        Random rand = new Random();
        int num1 = 10;
        int num2 = 20;

        // Generate 0 or 1 randomly
        int choice = rand.nextInt(2);

        int result = (choice == 0) ? num1 : num2;
        System.out.println("Randomly chosen number: " + result);
    }
}
