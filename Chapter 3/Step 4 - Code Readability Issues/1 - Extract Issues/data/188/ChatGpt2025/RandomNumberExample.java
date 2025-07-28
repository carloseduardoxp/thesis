import java.util.Random;

public class RandomNumberExample {
    public static void main(String[] args) {
        Random random = new Random();

        // Generate a random integer
        int randomNumber = random.nextInt();  // can be any int value

        System.out.println("Random number: " + randomNumber);
    }
}
