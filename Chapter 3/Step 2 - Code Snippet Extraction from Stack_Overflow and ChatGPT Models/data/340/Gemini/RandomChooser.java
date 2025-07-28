
import java.util.Random;

public class RandomChooser {
    public static void main(String[] args) {
        int number1 = 10;
        int number2 = 20;

        Random random = new Random();

        // Method 1: Generate a boolean and choose based on that
        boolean chooseFirst = random.nextBoolean();
        int chosenNumber;
        if (chooseFirst) {
            chosenNumber = number1;
        } else {
            chosenNumber = number2;
        }
        System.out.println("Chosen number (Method 1): " + chosenNumber);

        // Method 2: Generate 0 or 1 and use an array
        int[] numbers = {number1, number2};
        int randomIndex = random.nextInt(2); // Generates 0 or 1
        chosenNumber = numbers[randomIndex];
        System.out.println("Chosen number (Method 2): " + chosenNumber);

        // Method 3: Using a ternary operator (more concise for simple cases)
        chosenNumber = random.nextBoolean() ? number1 : number2;
        System.out.println("Chosen number (Method 3): " + chosenNumber);
    }
}
