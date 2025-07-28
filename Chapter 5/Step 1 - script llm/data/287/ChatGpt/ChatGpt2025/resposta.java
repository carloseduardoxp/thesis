public class Teste {

    private static final String HELLO_MESSAGE = "Hello, world!";

    public static void main(String[] args) {

        // Call the method with all arguments
        printMessage(HELLO_MESSAGE, 3, true);

        // Call the method with only the message argument
        printMessage(HELLO_MESSAGE, 1, false);

        // Call the method with only the message and count arguments
        printMessage(HELLO_MESSAGE, 2);

    }

    // Define the method with default values
    public static void printMessage(String message, int count, boolean bold) {
        // Implementation here
    }

    // Overloaded method for default bold value
    public static void printMessage(String message, int count) {
        printMessage(message, count, false);
    }
}
