import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<String> originalStream = Stream.of("A", "B", "C");
        Stream<String> newElementStream = Stream.of("D");

        Stream<String> combinedStream = Stream.concat(originalStream, newElementStream);
        combinedStream.forEach(System.out::println); // Output: A B C D
    }
}
