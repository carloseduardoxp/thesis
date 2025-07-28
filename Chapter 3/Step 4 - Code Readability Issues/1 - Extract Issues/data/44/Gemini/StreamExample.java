
import java.util.List;


public class StreamExample {
    public static void main(String[] args) {

        List<String> names = List.of("Alice", "Bob", "Charlie");
        names.stream().forEach(name -> System.out.println("Hello, " + name + "!"));

    }
}