import java.util.ArrayList;
import java.util.List;

public class ListExample {
    public static void main(String[] args) {
        List<String> myList = new ArrayList<>();

        myList.add("apple");
        myList.add("banana");
        myList.add("orange");

        System.out.println("My list: " + myList);
    }
}