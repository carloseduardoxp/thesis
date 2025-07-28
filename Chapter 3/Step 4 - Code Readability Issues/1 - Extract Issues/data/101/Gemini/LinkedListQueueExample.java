import java.util.LinkedList;
import java.util.Queue;

public class LinkedListQueueExample {
    public static void main(String[] args) {
        // Declare and instantiate a Queue using LinkedList
        Queue<String> messages = new LinkedList<>();

        System.out.println("Initial queue: " + messages);

        // Add elements using offer()
        messages.offer("Hello");
        messages.offer("World");
        messages.offer("Java");
        System.out.println("After offer(): " + messages); // Output: [Hello, World, Java]

        // Add an element using add()
        messages.add("Programming");
        System.out.println("After add(): " + messages); // Output: [Hello, World, Java, Programming]

        // Demonstrating FIFO (First-In, First-Out)
        System.out.println("Element at head (peek): " + messages.peek()); // Output: Hello
        System.out.println("Removing element (poll): " + messages.poll()); // Output: Hello
        System.out.println("Queue after poll: " + messages); // Output: [World, Java, Programming]
    }
}
