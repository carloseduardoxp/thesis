import java.util.*;

public class Teste {

    public static void main(String[] args) {        
        ArrayList<Integer[]> snakeParts = new ArrayList<>();
        snakeParts.add(new Integer[]{1,2});
        snakeParts.add(new Integer[]{3,4});
        snakeParts.add(new Integer[]{5,6});
        snakeParts.add(0, new Integer[]{0,0});
        int[][] array = snakeParts.toArray(new int[snakeParts.size()][]);
    }
}
