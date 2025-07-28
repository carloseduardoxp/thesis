import java.util.LinkedList;

public class LinkedListRemoval {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        list.add("Date");
        
        // Remove by index
        list.remove(1); // Removes "Banana" (index 1)
        
        // Remove by object
        list.remove("Cherry"); // Removes "Cherry" if present
        
        // Remove first element
        list.removeFirst();
        
        // Remove last element
        list.removeLast();
        
        System.out.println(list); // Output: []
    }
}
