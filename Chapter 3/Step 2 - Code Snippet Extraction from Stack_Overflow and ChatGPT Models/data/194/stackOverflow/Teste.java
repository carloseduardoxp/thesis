import java.util.*;

public class Teste {

    public static void main(String[] args) {        
        ArrayList<Integer[]> snake_parts = new ArrayList<Integer[]>();
        snake_parts.add(new Integer[]{1,2});
        snake_parts.add(new Integer[]{3,4});
        snake_parts.add(new Integer[]{5,6});
        snake_parts.add(0,new Integer[]{0,0});
        int[][] array= new int[snake_parts.size()][];
        array = snake_parts.toArray(array);
    }
}