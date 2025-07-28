import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("cherry");

        boolean hasBanana = list.contains("banana");
        System.out.println("Contains banana? " + hasBanana);
    }
}
