import java.util.Arrays;

public class DeepSeek {
    public static void main(String[] args) {
        // Sorting a primitive array (int)
        int[] numbers = {5, 2, 9, 1, 5, 6};
        Arrays.sort(numbers);
        System.out.println("Sorted numbers: " + Arrays.toString(numbers));
        
        // Sorting a String array
        String[] names = {"John", "Alice", "Bob", "Eve"};
        Arrays.sort(names);
        System.out.println("Sorted names: " + Arrays.toString(names));
    }
}
