import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(List.of(5, 2, 9, 1, 5));
        
        // Natural ordering (ascending)
        Collections.sort(numbers);
        System.out.println("Ascending: " + numbers);
        
        // Custom ordering (descending)
        Collections.sort(numbers, Collections.reverseOrder());
        System.out.println("Descending: " + numbers);
    }
}
