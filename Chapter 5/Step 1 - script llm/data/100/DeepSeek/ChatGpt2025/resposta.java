import java.util.*;

public class DeepSeek {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5);

        // Using HashSet (doesn't maintain order)
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        // Using LinkedHashSet (maintains insertion order)
        Set<Integer> uniqueOrderedNumbers = new LinkedHashSet<>(numbers);

    }

}