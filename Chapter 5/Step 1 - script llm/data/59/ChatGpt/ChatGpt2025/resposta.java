import java.util.ArrayList;

public class Example {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("foo");
        list.add("bar");
        list.add("baz");

        for (String element : list) {
            System.out.println(element);
        }
    }
}