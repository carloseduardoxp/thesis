
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Teste {
  public static void main(String[] args) {
    String[] arrayWithDuplicates = {"apple", "banana", "orange", "banana", "kiwi", "orange"};
    Set<String> setWithoutDuplicates = new HashSet<>(Arrays.asList(arrayWithDuplicates));
    String[] arrayWithoutDuplicates = setWithoutDuplicates.toArray(new String[0]);

  }
}
