public class GreetingService {

    // Method with all parameters
    public void greet(String name, String salutation) {
        System.out.println(salutation + ", " + name + "!");
    }

    // Overloaded method with a default salutation
    public void greet(String name) {
        greet(name, "Hello"); // Calls the more comprehensive method with a default
    }

    // Overloaded method with default name and salutation
    public void greet() {
        greet("Guest", "Hello"); // Calls the more comprehensive method with defaults
    }

    public static void main(String[] args) {
        GreetingService service = new GreetingService();

        service.greet("Alice", "Hi");   // Output: Hi, Alice!
        service.greet("Bob");           // Output: Hello, Bob! (uses default salutation)
        service.greet();                // Output: Hello, Guest! (uses default name and salutation)
    }
}
