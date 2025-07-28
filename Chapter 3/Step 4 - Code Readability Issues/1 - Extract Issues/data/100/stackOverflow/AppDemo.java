
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class AppDemo {

    public void removeTheDuplicates(List<Customer>myList) {
        for(ListIterator<Customer>iterator = myList.listIterator(); iterator.hasNext();) {
            Customer customer = iterator.next();
            if(Collections.frequency(myList, customer) > 1) {
                iterator.remove();
            }
        }
        System.out.println(myList.toString());
    
    }
}