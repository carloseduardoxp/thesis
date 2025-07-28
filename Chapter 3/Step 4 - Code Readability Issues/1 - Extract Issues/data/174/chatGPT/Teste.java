
import java.util.*;

public class Teste {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        System.out.println("Original list: " + numbers);

        Collections.reverse(numbers);

        System.out.println("Reversed list: " + numbers);

    }
}
