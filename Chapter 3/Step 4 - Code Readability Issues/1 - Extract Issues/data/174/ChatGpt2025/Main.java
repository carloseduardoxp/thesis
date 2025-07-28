import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C", "D"));
        Collections.reverse(list); // modifies the original list
        System.out.println("Reversed list: " + list);
    }
}
