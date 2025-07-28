import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Teste {

    public static void main(String[] args) {
        int[] intarray = {1,2,3,4,5,1,2,3,4,5,1,2,3,4,5};
    
        Set<Integer> set = new HashSet<>();
        for(int i : intarray) {
            set.add(i);
        }
    
        Iterator<Integer> setitr = set.iterator();
        for(int pos=0; pos < intarray.length; pos ++) {
            if(pos < set.size()) {
                intarray[pos] =setitr.next();
            } else {
                intarray[pos]= 0;
            }
        }
    
        for(int i: intarray) {
            System.out.println(i);
        }
    }
}
