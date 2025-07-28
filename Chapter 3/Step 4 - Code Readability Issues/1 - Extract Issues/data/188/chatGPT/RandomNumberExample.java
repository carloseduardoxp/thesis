import java.util.Random;

public class RandomNumberExample {

    public static void main(String[] args) {
        // Create a new Random object
        Random random = new Random();

        // Generate a random integer between 0 and 99
        int randomNumber = random.nextInt(100);

        // Print the random number to the console
        System.out.println("Random number: " + randomNumber);
    }
}
