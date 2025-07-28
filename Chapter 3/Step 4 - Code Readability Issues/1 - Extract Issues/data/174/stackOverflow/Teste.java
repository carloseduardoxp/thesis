
import java.util.*;

public class Teste {

    public static void main(String[] args) {        
        List<Integer> nums = new ArrayList<Integer>();
        nums.add(61);
        nums.add(42);
        nums.add(83);
        nums.add(94);
        nums.add(15);
        //Tosort the collections uncomment the below line
        //Collections.sort(nums); 
        
        Collections.reverse(nums);
        
        System.out.println(nums);
    }
}