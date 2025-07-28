import java.util.Arrays;

public class ArrayFilter {
    public static void main(String[] args) {
        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        
        // Filter even numbers
        Integer[] evenNumbers = Arrays.stream(numbers)
                                    .filter(n -> n % 2 == 0)
                                    .toArray(Integer[]::new);
        
        System.out.println(Arrays.toString(evenNumbers));
    }
}
