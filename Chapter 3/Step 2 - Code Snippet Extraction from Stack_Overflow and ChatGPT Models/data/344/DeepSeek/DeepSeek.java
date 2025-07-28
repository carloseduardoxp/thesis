
import java.util.stream.Stream;


public class DeepSeek {

    public static void main(String[] args) {

        Stream<String> originalStream = Stream.of("A", "B", "C");
        Stream<String> newStream = Stream.concat(originalStream, Stream.of("D"));

// Or to add multiple elements:
        Stream<String> newStream2 = Stream.concat(
                originalStream,
                Stream.of("D", "E", "F")
        );

    }

}
