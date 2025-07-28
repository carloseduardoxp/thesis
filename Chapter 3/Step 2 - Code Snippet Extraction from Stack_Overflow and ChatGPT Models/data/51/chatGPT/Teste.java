import org.eclipse.collections.api.bag.Bag;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.impl.factory.Bags;

public class BagExample {
    public static void main(String[] args) {
        MutableBag<String> bag = Bags.mutable.empty();
        bag.addOccurrences("apple", 2);
        bag.add("banana");
        bag.add("orange");

        System.out.println("Bag: " + bag);
        System.out.println("Size: " + bag.size());
        System.out.println("Occurrences of apple: " + bag.occurrencesOf("apple"));
    }
}
