
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParallelStreamExample {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Process elements in parallel and double each number
        List<Integer> doubledNumbers = numbers.parallelStream()
                                              .map(n -> {
                                                  System.out.println("Processing " + n + " in thread: " + Thread.currentThread().getName());
                                                  // Simulate some work
                                                  try {
                                                      Thread.sleep(100);
                                                  } catch (InterruptedException e) {
                                                      Thread.currentThread().interrupt();
                                                  }
                                                  return n * 2;
                                              })
                                              .collect(Collectors.toList());

        System.out.println("Doubled numbers: " + doubledNumbers);
    }
}
