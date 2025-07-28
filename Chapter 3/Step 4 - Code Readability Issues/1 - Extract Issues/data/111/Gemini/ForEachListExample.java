import java.util.ArrayList;
import java.util.List;

public class ForEachListExample {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);

        System.out.println("\n--- Iterating over numbers list ---");
        for (Integer num : numbers) {
            System.out.println("Number: " + num);
        }
    }
}