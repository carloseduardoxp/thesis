import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.impl.bag.mutable.HashBag;

public class BagExample {
    public static void main(String[] args) {
        MutableBag<String> bag = new HashBag<>();

        bag.add("apple");
        bag.add("banana", 2); // Add "banana" twice
        bag.add("apple");

        System.out.println("Bag contents: " + bag); // [banana, banana, apple, apple]
        System.out.println("Occurrences of 'apple': " + bag.occurrencesOf("apple")); // 2
        System.out.println("Occurrences of 'banana': " + bag.occurrencesOf("banana")); // 2

        bag.remove("apple");
        System.out.println("After removing one 'apple': " + bag.occurrencesOf("apple")); // 1

        bag.forEachWithOccurrences((item, count) ->
            System.out.println(item + " appears " + count + " times"));
    }
}
