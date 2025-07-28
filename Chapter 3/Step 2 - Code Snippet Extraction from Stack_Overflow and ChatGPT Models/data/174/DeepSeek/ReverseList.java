import java.util.Collections;
import java.util.List;
import java.util.Arrays;

public class ReverseList {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("Original list: " + list);
        
        Collections.reverse(list);
        
        System.out.println("Reversed list: " + list);
    }
}
