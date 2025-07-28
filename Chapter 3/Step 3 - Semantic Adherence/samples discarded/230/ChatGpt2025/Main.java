@FunctionalInterface
interface GreetingService {
    void greet(String name); // Single Abstract Method
}
public class Main {
    public static void main(String[] args) {
        // Lambda expression implementing the SAM
        GreetingService greeting = (name) -> System.out.println("Hello, " + name + "!");
        
        greeting.greet("Alice");
    }
}
