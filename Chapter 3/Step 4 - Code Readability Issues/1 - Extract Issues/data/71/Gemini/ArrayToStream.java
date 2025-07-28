
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArrayToStream {

    public static void main(String[] args) {

        // --- Creating a Stream from a primitive array (e.g., int[]) ---
        int[] intArray = {1, 2, 3, 4, 5};
        System.out.println("--- Stream from int[] ---");

        // Use Arrays.stream() for primitive arrays to get a specialized primitive stream (e.g., IntStream)
        IntStream intStream = Arrays.stream(intArray);

        // Demonstrate a common stream operation: forEach to print elements
        System.out.print("Elements: ");
        intStream.forEach(element -> System.out.print(element + " "));
        System.out.println("\n"); // New line for better formatting


        // --- Creating a Stream from an object array (e.g., String[]) ---
        String[] stringArray = {"apple", "banana", "cherry", "date"};
        System.out.println("--- Stream from String[] ---");

        // Use Arrays.stream() for object arrays to get a regular Stream<T>
        Stream<String> stringStream = Arrays.stream(stringArray);

        // Demonstrate another common stream operation: filter and then forEach
        System.out.print("Elements starting with 'b': ");
        stringStream.filter(s -> s.startsWith("b"))
                    .forEach(s -> System.out.print(s + " "));
        System.out.println("\n");


        // --- Another way to create a Stream from an array (Stream.of()) ---
        // This method is more flexible as it can take individual elements or an array
        System.out.println("--- Stream using Stream.of() ---");

        Integer[] integerObjectArray = {10, 20, 30, 40};
        Stream<Integer> integerStream = Stream.of(integerObjectArray);
        System.out.print("Elements from Integer[] using Stream.of(): ");
        integerStream.forEach(element -> System.out.print(element + " "));
        System.out.println("\n");

        // You can also pass individual elements to Stream.of()
        Stream<Double> doubleStream = Stream.of(1.1, 2.2, 3.3);
        System.out.print("Elements from individual doubles using Stream.of(): ");
        doubleStream.forEach(element -> System.out.print(element + " "));
        System.out.println();
    }
}
