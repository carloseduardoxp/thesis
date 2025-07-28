import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Integer[] numbers = {5, 2, 9, 1, 10};

        Arrays.sort(numbers, Collections.reverseOrder());

        System.out.println(Arrays.toString(numbers)); // [10, 9, 5, 2, 1]
    }
}
