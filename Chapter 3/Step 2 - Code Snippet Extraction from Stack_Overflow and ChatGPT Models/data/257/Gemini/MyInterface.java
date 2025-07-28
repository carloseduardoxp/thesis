public interface MyInterface {
    // Declare abstract methods
    void doSomething();
    int calculate(int a, int b);

    // Declare constants (implicitly public static final)
    String DEFAULT_MESSAGE = "Hello from MyInterface";

    // (Java 8+) Default methods
    default void logMessage(String message) {
        System.out.println("Log: " + message);
    }

    // (Java 8+) Static methods
    static void printInfo() {
        System.out.println("This is an interface information.");
    }

    // (Java 9+) Private methods (can be used by default/static methods)
    private void helperMethod() {
        System.out.println("This is a private helper method.");
    }
}
