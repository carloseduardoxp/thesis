public class Example {
    // Primary method with all parameters
    public void greet(String name, String greeting) {
        System.out.println(greeting + ", " + name + "!");
    }

    // Overloaded method with default greeting
    public void greet(String name) {
        greet(name, "Hello"); // Default greeting
    }

    public static void main(String[] args) {
        Example example = new Example();
        example.greet("Alice");       // Uses default greeting ("Hello")
        example.greet("Bob", "Hi");   // Uses provided greeting ("Hi")
    }
}
