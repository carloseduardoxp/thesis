import java.util.LinkedList;

public class DeepSeek {
    public static void main(String[] args) {
        // Create a LinkedList
        LinkedList<String> linkedList = new LinkedList<>();
        
        // Add elements
        linkedList.add("Apple");
        linkedList.add("Banana");
        linkedList.addFirst("Orange"); // Add to beginning
        linkedList.addLast("Grapes");  // Add to end
        
        // Access elements
        linkedList.getFirst();
        linkedList.getLast();
        linkedList.get(1); // Get by index
        
        // Remove elements
        linkedList.removeFirst();
        linkedList.removeLast();
        linkedList.remove(1); // Remove by index
        linkedList.remove("Banana"); // Remove by value
        
        // Check if list contains element
        linkedList.contains("Apple");
        
        // Get size
        linkedList.size();
        
        // Iterate through the list
        for (String fruit : linkedList) {
            System.out.println(fruit);
        }
    }
}
