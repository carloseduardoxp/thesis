import java.util.*;

public class Teste {

    public static void main(String[] args) {        
        List<Integer> nums = new ArrayList<>();
        nums.add(61);
        nums.add(42);
        nums.add(83);
        nums.add(94);
        nums.add(15);
        
        Collections.reverse(nums);
        
        System.out.println(nums);
    }
}
