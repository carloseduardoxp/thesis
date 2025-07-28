import java.util.Iterator;
import java.util.LinkedList;

public class Teste {
    
    public static void main(String[] args) {

        LinkedList list;

        for(Iterator<String> iter = list.iterator(); iter.hasNext();) {
            String s = iter.next();
            System.out.println(s);
        }
}
    
}