import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.HashBag; // A common implementation

public class BagExample {
    private static final String APPLE = "apple";
    private static final String BANANA = "banana";

    public static void main(String[] args) {
        Bag<String> myBag = new HashBag<>();

        // Add elements (duplicates are allowed)
        myBag.add(APPLE);
        myBag.add(BANANA);
        myBag.add(APPLE);
        myBag.add("orange");
        myBag.add(BANANA);
        myBag.add(BANANA);

        // Get the number of times an element appears
        System.out.println("Count of apple: " + myBag.getCount(APPLE)); // Output: 2
        System.out.println("Count of banana: " + myBag.getCount(BANANA)); // Output: 3

        // Get the total number of elements in the bag (including duplicates)
        System.out.println("Total elements in bag: " + myBag.size()); // Output: 6

        // Get the number of unique elements
        System.out.println("Unique elements in bag: " + myBag.uniqueSize()); // Output: 3

        // Check if an element exists
        System.out.println("Contains apple? " + myBag.contains(APPLE)); // Output: true
        System.out.println("Contains grape? " + myBag.contains("grape")); // Output: false

        // Iterate over the elements (order is not guaranteed)
        System.out.println("Elements in the bag:");
        myBag.forEach(System.out::println);
    }
}
