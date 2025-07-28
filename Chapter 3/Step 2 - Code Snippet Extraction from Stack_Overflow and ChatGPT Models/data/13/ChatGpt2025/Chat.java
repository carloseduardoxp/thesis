import java.util.Iterator;
import java.util.LinkedList;

public class Chat {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Apple");          // Add at the end
        list.addFirst("Banana");    // Add at the beginning
        list.addLast("Cherry");     // Add at the end (same as add())
        String first = list.getFirst();  // Get the first element
        String last = list.getLast();    // Get the last element
        String item = list.get(1);       // Get element at index 1
        list.removeFirst();        // Remove first element
        list.removeLast();         // Remove last element
        list.remove("Apple");      // Remove specific element
        list.remove(1);            // Remove by index
        for (String fruit : list) {
            System.out.println(fruit);
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
