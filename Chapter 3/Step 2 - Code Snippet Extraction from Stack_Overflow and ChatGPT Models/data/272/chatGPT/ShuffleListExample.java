import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShuffleListExample {
   public static void main(String[] args) {
      // Create a list of integers
      List<Integer> numbers = new ArrayList<>();
      numbers.add(1);
      numbers.add(2);
      numbers.add(3);
      numbers.add(4);
      numbers.add(5);

      // Shuffle the list
      Collections.shuffle(numbers);

      // Print the shuffled list
      System.out.println("Shuffled list: " + numbers);
   }
}
