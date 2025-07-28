import java.util.LinkedList;
import java.util.Queue;

public class ExampleQueue {
  public static void main(String[] args) {
    Queue<String> queue = new LinkedList<>();
    
    // Adding elements to the queue using add() method
    queue.add("element 1");
    queue.add("element 2");
    queue.add("element 3");
    
    // Displaying the contents of the queue
    System.out.println("Queue: " + queue);
  }
}
