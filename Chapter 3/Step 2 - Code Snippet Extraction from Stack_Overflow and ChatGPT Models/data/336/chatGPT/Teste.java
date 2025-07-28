
import java.util.Arrays;
import java.util.List;

public class Teste {
  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    list.parallelStream().forEach(i -> {
        // do something with i in a thread-safe way
    });
  }
}
