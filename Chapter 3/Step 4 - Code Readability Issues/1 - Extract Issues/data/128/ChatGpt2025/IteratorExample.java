import java.util.*;

public class IteratorExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");

        Iterator<String> it = names.iterator();

        while (it.hasNext()) {
            String name = it.next();
            System.out.println(name);

            // Example of removing an element
            if (name.equals("Bob")) {
                it.remove();
            }
        }

        System.out.println("After removal: " + names);
    }
}
