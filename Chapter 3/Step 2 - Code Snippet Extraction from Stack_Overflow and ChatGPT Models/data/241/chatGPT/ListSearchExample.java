import java.util.ArrayList;
import java.util.List;

public class ListSearchExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");

        boolean containsBob = names.contains("Bob");
        System.out.println("List contains Bob: " + containsBob);

        boolean containsDave = names.contains("Dave");
        System.out.println("List contains Dave: " + containsDave);
    }
}
