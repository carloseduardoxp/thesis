import java.util.LinkedList;

public class DateExample {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("foo");
        list.add("bar");
        list.add("baz");

        // Remove an element by index
        list.remove(1); // removes "bar"

        // Remove an element by value
        list.remove("foo"); // removes "foo"

        System.out.println(list); // prints "[baz]"



    }
}
