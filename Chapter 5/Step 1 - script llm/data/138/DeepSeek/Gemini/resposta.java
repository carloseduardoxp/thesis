import java.util.*;

public class DeepSeek {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        List<String> elementsToAdd = Arrays.asList("a", "b", "c");

// Using lambda with forEach
        elementsToAdd.forEach(list::add);

    }

}
