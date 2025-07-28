import java.util.stream.IntStream;

public class StreamExample {
    public static void main(String[] args) {
        Integer[] integers = {1, 2, 3, 4, 5};

        // Convert the Stream<Integer> to an int[]
        int[] ints = IntStream.of(integers)
                .mapToInt(Integer::intValue)
                .toArray();

        // Print the int[] to the console
        for (int i : ints) {
            System.out.print(i + " ");
        }
    }
}
