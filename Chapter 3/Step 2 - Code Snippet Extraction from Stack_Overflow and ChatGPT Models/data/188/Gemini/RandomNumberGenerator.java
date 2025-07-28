import java.util.Random; // Import the Random class

public class RandomNumberGenerator {

    public static void main(String[] args) {
        // Create an instance of the Random class
        Random random = new Random();

        // Generate a random integer
        // By default, nextInt() generates a random integer across the entire range of int.
        int randomNumber1 = random.nextInt();
        System.out.println("Random integer (full range): " + randomNumber1);

        // Generate a random integer within a specific range (e.g., 0 to 99)
        // nextInt(bound) generates a random integer from 0 (inclusive) to bound (exclusive).
        int randomNumber2 = random.nextInt(100); // Generates a number from 0 to 99
        System.out.println("Random integer (0-99): " + randomNumber2);

        // Generate a random integer within a custom range (e.g., 1 to 10)
        // Formula: min + random.nextInt(max - min + 1)
        int min = 1;
        int max = 10;
        int randomNumber3 = random.nextInt(max - min + 1) + min;
        System.out.println("Random integer (1-10): " + randomNumber3);

        // Generate a random double between 0.0 (inclusive) and 1.0 (exclusive)
        double randomDouble = random.nextDouble();
        System.out.println("Random double (0.0-1.0): " + randomDouble);

        // Generate a random boolean
        boolean randomBoolean = random.nextBoolean();
        System.out.println("Random boolean: " + randomBoolean);
    }
}
