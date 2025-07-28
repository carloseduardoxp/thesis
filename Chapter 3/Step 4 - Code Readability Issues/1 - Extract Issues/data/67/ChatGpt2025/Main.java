import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);

        list.add(0, 5); // Add 5 at the beginning

        System.out.println(list); // Output: [5, 10, 20, 30]
    }
}
