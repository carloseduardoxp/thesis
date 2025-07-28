import java.util.ArrayList;
import java.util.Iterator;

public class IteratorExample {
    public static void main(String[] args) {
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        
        // Get an iterator
        Iterator<String> iterator = fruits.iterator();
        
        // Iterate through the elements
        while(iterator.hasNext()) {
            String fruit = iterator.next();
            System.out.println(fruit);
            
            // Can remove elements safely during iteration
            if(fruit.equals("Banana")) {
                iterator.remove();
            }
        }
    }
}
