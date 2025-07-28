public class Teste {
    private static final String HELLO_WORLD = "Hello, world!";
  
    public static void main(String[] args) {
        // Call the method with all arguments
        printMessage(HELLO_WORLD, 3, true);

        // Call the method with only the message argument
        printMessage(HELLO_WORLD, 1, false);

        // Call the method with only the message and count arguments
        printMessage(HELLO_WORLD, 2);
    }

    public static void printMessage(String message, int count, boolean bold) {
        // Implementation here
    }

    public static void printMessage(String message, int count) {
        printMessage(message, count, false);
    }
}
