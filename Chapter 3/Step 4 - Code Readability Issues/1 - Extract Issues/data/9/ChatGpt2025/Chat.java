import java.util.ArrayList;

public class Chat {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);

        // Pop last element
        int lastElement = list.remove(list.size() - 1);
        System.out.println("Popped: " + lastElement); // 30
        System.out.println("Remaining: " + list);     // [10, 20]
    }
}
