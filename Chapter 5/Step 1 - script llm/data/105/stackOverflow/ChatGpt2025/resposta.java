import java.util.ArrayList;

public class AppDemo {

    public static void main(String[] args) {
        ArrayList<Integer> str = new ArrayList<>();
        str.add(0);
        str.add(1);
        str.add(2);
        str.add(3); 
        //Result = [0, 1, 2, 3]
        str.add(1, 11);
        str.add(2, 12);
        //Result = [0, 11, 12, 1, 2, 3]
    
    }
}