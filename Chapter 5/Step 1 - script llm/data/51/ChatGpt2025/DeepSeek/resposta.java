import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.impl.bag.mutable.HashBag;

public class BagExample {
    private static final String APPLE = "apple";
    private static final String BANANA = "banana";

    public static void main(String[] args) {
        MutableBag<String> bag = new HashBag<>();

        bag.add(APPLE);
        bag.add(BANANA, 2); // Add "banana" twice
        bag.add(APPLE);

        System.out.println("Bag contents: " + bag); // [banana, banana, apple, apple]
        System.out.println("Occurrences of 'apple': " + bag.occurrencesOf(APPLE)); // 2
        System.out.println("Occurrences of 'banana': " + bag.occurrencesOf(BANANA)); // 2

        bag.remove(APPLE);
        System.out.println("After removing one 'apple': " + bag.occurrencesOf(APPLE)); // 1

        bag.forEachWithOccurrences((item, count) ->
            System.out.println(item + " appears " + count + " times"));
    }
}