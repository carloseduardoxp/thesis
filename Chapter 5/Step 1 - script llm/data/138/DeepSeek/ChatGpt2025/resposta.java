import java.util.*;

public class DeepSeek {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        List<String> elementsToAdd = Arrays.asList("a", "b", "c");

        // Using method reference with forEach
        elementsToAdd.forEach(list::add);

    }

}
