import java.util.*;

public class MyIterator implements Iterator<Integer> {
    private List<Integer> list;
    private int index;

    public MyIterator(List<Integer> list) {
        this.list = list;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        int value = list.get(index);
        index++;
        return value;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}

class Teste {
    public static void main(String[] args) {
        List<Integer> myList = Arrays.asList(1, 2, 3, 4, 5);
        MyIterator myIterator = new MyIterator(myList);

        while (myIterator.hasNext()) {
            int value = myIterator.next();
            System.out.println(value);
        }
    }
}
