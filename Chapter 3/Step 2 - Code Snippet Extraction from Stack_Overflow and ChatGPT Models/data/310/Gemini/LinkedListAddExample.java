import java.util.LinkedList;

public class LinkedListAddExample {
    public static void main(String[] args) {
        LinkedList<String> fruits = new LinkedList<>();

        // Using add(E e)
        fruits.add("Apple");
        fruits.add("Banana");
        System.out.println("After adding Apple and Banana: " + fruits); // Output: [Apple, Banana]

        // Using addLast(E e)
        fruits.addLast("Cherry");
        System.out.println("After adding Cherry with addLast: " + fruits); // Output: [Apple, Banana, Cherry]
    }
}
