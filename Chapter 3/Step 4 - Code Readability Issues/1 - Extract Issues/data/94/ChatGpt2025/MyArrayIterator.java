import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayIterator implements Iterator<Integer> {
    private int[] data;
    private int index = 0;

    public MyArrayIterator(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        return index < data.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[index++];
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }
}

