import java.util.Arrays;

public class FilterArrayExample {

    public static void main(String[] args) {
        // Create an array of integers
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // Filter the even numbers from the array using a Stream and a predicate
        int[] evenNumbers = Arrays.stream(numbers)
                                  .filter(n -> n % 2 == 0)
                                  .toArray();

        // Print the even numbers to the console
        System.out.println(Arrays.toString(evenNumbers));
    }
}
