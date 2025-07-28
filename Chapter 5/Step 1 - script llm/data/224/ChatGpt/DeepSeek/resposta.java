import java.util.ArrayList;
import java.util.Optional;

public class Teste {
    private static final String BANANA = "banana";
    private static final String GRAPE = "grape";
    
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("apple");
        list.add(BANANA);
        list.add("orange");
        System.out.println(list.indexOf(BANANA)); // 1
        System.out.println(list.indexOf(GRAPE)); // -1

        System.out.println(list.lastIndexOf(BANANA)); // 3
        System.out.println(list.lastIndexOf(GRAPE)); // -1

        Optional<String> result = list.stream().filter(e -> e.startsWith("b")).findFirst();
        if (result.isPresent()) {
            System.out.println(result.get()); // "banana"
        } else {
            System.out.println("No element found.");
        }
    }
}