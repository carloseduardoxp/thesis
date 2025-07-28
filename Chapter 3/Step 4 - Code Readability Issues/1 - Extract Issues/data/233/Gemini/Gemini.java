
import java.util.function.Consumer;


class Greeter {

    public void greet(String name) {
        System.out.println("Hello, " + name);
    }
}

public class Gemini {

    public static void main(String[] args) {
        Greeter greeter = new Greeter();
// Lambda equivalent: (name) -> greeter.greet(name)
        Consumer<String> greeterMethod = greeter::greet;
        greeterMethod.accept("Alice"); // Prints "Hello, Alice"        
    }
}
