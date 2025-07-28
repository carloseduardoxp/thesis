import java.util.stream.Stream;

public class StreamBuildingExample {
    public static void main(String[] args) {
        Stream.Builder<String> builder = Stream.builder();

        builder.add("apple");
        builder.add("banana");
        builder.add("cherry");

        Stream<String> fruitStream = builder.build();
        fruitStream.forEach(System.out::println);
        // Output:
        // apple
        // banana
        // cherry
    }
}
