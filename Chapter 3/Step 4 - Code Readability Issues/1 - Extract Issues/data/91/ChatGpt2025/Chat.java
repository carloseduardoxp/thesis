
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Chat {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(5, 3, 8, 1);

        List<Integer> sortedDesc = numbers.stream()
                .sorted((a, b) -> b - a) // Comparator for descending order
                .collect(Collectors.toList());

        System.out.println(sortedDesc);  // Output: [8, 5, 3, 1]

    }

}
