import java.util.LinkedList;

public class Teste {

    public static void main(String[] args) {


        LinkedList<String> myList = new LinkedList<>();

        // Remove the first element of the list
        myList.removeFirst();

        // Remove an element at a specific index
        myList.remove(2);

        // Remove an element by its value
        myList.remove("banana");


    }

}
