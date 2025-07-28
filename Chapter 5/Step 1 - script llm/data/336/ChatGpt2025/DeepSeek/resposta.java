import java.util.Arrays;
import java.util.List;

public class Chat {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c", "d");

        // Process each element in parallel
        list.parallelStream().forEach(element -> 
            System.out.println(Thread.currentThread().getName() + " processing " + element)
        );
    }
}