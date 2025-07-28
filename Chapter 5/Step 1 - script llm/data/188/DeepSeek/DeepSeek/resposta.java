public class DeepSeek {

    public static void main(String[] args) {
        java.util.Random random = new java.util.Random();

        // Generates a random double between 0.0 (inclusive) and 1.0 (exclusive)
        double randomDouble = random.nextDouble();
        System.out.println("Random double: " + randomDouble);

        // To get a random integer between 0 and 99:
        int randomInt = random.nextInt(100);
        System.out.println("Random integer (0-99): " + randomInt);
    }
}