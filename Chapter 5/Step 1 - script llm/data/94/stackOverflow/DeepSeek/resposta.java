import java.util.Iterator;
import java.util.ArrayList;

public class AppDemo {

    public static void main(String[] args) {

        Bag<String> bag1 = new Bag<>();

        bag1.add("alice");
        bag1.add("bob"); 
        bag1.add("abigail");
        bag1.add("charlie"); 

        for (Iterator<String> it1 = bag1.iterator(); it1.hasNext();) {
            String s = it1.next();
            if (s != null)
                System.out.println(s); 
        }
    }
}

class Bag<T> {

    private ArrayList<T> data;

    public Bag() {
        data = new ArrayList<>();
    }

    public void add(T e) {
        data.add(e); 
    }

    public Iterator<T> iterator() {
        return new BagIterator();
    }

    public class BagIterator implements Iterator<T> {
        private int index; 

        public BagIterator() {
            index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < data.size();  
        }

        @Override
        public T next() {
            String str = (String) data.get(index); 
            if (str.startsWith("a"))
                return data.get(index++); 
            index++; 
            return null; 
        }
    } 
}
