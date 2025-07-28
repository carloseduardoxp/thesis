public class Example {

    // Method with two parameters
    public void greet(String name, String message) {
        System.out.println(message + ", " + name + "!");
    }

    // Overloaded method with one parameter, uses default message
    public void greet(String name) {
        greet(name, "Hello");  // default value for message is "Hello"
    }

    public static void main(String[] args) {
        Example ex = new Example();

        ex.greet("Alice", "Good morning"); // Output: Good morning, Alice!
        ex.greet("Bob");                    // Output: Hello, Bob! (default message used)
    }
}
