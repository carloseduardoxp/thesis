import org.eclipse.collections.api.bag.Bag;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.impl.bag.mutable.HashBag;

public class BagExample {
    private static final String APPLE = "apple";
    private static final String BANANA = "banana";
    private static final String ORANGE = "orange";

    public static void main(String[] args) {
        // Creating a Bag
        MutableBag<String> bag = HashBag.newBagWith(APPLE, BANANA, APPLE, ORANGE, BANANA, APPLE);
        
        // Count occurrences
        System.out.println("Count of 'apple': " + bag.occurrencesOf(APPLE)); // 3
        System.out.println("Count of 'banana': " + bag.occurrencesOf(BANANA)); // 2
        
        // Adding elements
        bag.add(ORANGE);
        bag.addOccurrences(APPLE, 2); // Add 2 more apples
        
        // Removing elements
        bag.remove(BANANA);
        bag.removeOccurrences(APPLE, 1); // Remove 1 apple
        
        // Iterating through unique elements with counts
        System.out.println("\nElements with counts:");
        bag.forEachWithOccurrences((each, count) -> 
            System.out.println(each + ": " + count));
    }
}
