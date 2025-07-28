import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesExample {
   public static void main(String[] args) {
      // Create an array with duplicate elements
      Integer[] arr = { 1, 2, 3, 1, 2, 4, 5, 4, 6, 7, 8, 7 };

      // Convert the array to a set to remove duplicates
      Set<Integer> set = new HashSet<>(Arrays.asList(arr));

      // Convert the set back to an array
      Integer[] newArr = set.toArray(new Integer[0]);

      // Print the array without duplicates
      System.out.println(Arrays.toString(newArr));
   }
}
