import org.eclipse.collections.api.bag.Bag;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.impl.bag.mutable.HashBag;

public class BagExample {
    public static void main(String[] args) {
        // Creating a Bag
        MutableBag<String> bag = HashBag.newBagWith("apple", "banana", "apple", "orange", "banana", "apple");
        
        // Count occurrences
        System.out.println("Count of 'apple': " + bag.occurrencesOf("apple")); // 3
        System.out.println("Count of 'banana': " + bag.occurrencesOf("banana")); // 2
        
        // Adding elements
        bag.add("orange");
        bag.addOccurrences("apple", 2); // Add 2 more apples
        
        // Removing elements
        bag.remove("banana");
        bag.removeOccurrences("apple", 1); // Remove 1 apple
        
        // Iterating through unique elements with counts
        System.out.println("\nElements with counts:");
        bag.forEachWithOccurrences((each, count) -> 
            System.out.println(each + ": " + count));
        
        // Converting to other collections
        Set<String> uniqueItems = bag.toSet();
        List<String> flattened = bag.toList();
    }
}
