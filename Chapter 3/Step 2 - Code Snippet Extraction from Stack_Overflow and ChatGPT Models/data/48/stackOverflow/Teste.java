
import java.util.TreeSet;

public class Teste {

    
    public static void main(String[] args) {
        TreeSet treeSetObj = new TreeSet(new Comparator()
        {
            public int compare(String i1,String i2)
            {
                return i2.compareTo(i1);
            }
        });
    }
    
}