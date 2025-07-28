import java.util.ListIterator;

public class Teste {

    public static void main(String[] args) {
        ListIterator<String> listIterator = List_Of_Array.listIterator();

        /* Use void remove() method of ListIterator to remove an element from List.
     It removes the last element returned by next or previous methods.
         */
        listIterator.next();

//remove element returned by last next method
        listIterator.remove();//remove element at 1st position
        listIterator.next();
        listIterator.next();
        listIterator.remove();//remove element at 3rd position
        listIterator.next();
        listIterator.next();
        listIterator.remove();//remove element at 5th position
    }
}