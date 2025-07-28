import java.util.LinkedList;

public class Example {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        // Add element at the end
        list.add("Hello");

        // Add element at the beginning
        list.addFirst("Start");

        // Add element at a specific position (index)
        list.add(1, "Middle");

        System.out.println(list); // Output: [Start, Middle, Hello]
    }
}
