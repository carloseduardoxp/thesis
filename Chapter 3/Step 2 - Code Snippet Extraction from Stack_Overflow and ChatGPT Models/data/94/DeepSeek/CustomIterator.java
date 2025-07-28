import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomIterator<T> implements Iterator<T> {
    private final T[] elements;
    private int currentIndex = 0;

    public CustomIterator(T[] elements) {
        this.elements = elements;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < elements.length;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return elements[currentIndex++];
    }

    // Optional: remove operation
    @Override
    public void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }
}
