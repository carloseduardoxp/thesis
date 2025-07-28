import java.util.stream.Stream;

public class DeepSeek {

    public static void main(String[] args) {

        Stream<String> originalStream = Stream.of("A", "B", "C");
        Stream.concat(originalStream, Stream.of("D"));

        // Or to add multiple elements:
        Stream.concat(
                originalStream,
                Stream.of("D", "E", "F")
        );

    }

}