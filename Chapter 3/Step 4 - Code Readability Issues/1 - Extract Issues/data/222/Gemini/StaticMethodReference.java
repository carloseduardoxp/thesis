import java.util.function.Consumer;

public class StaticMethodReference {
    public static void printMessage(String message) {
        System.out.println("Static method received: " + message);
    }

    public static void main(String[] args) {
        // Using a lambda expression
        Consumer<String> consumerLambda = msg -> printMessage(msg);
        consumerLambda.accept("Hello from lambda!");

        // Using a method reference to a static method
        Consumer<String> consumerMethodRef = StaticMethodReference::printMessage;
        consumerMethodRef.accept("Hello from method reference!");
    }
}
