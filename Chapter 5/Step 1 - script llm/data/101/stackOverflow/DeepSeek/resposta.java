public class PriorityQueue<T> {

    private java.util.PriorityQueue<IntPriorityComparableWrapper<T>> queue;

    public PriorityQueue() {
            queue = new java.util.PriorityQueue<>();
    }

    public void add( int priority, T object ) {
            queue.add( new IntPriorityComparableWrapper<>(object, priority) );
    }

    public T get() {
            return (null != queue.peek())? queue.poll().getObject() : null;
    }


    /**
     * A "wrapper" to impose comparable properties on any object placed in the
     * queue.
     */
    private static class IntPriorityComparableWrapper<T>
    implements Comparable<IntPriorityComparableWrapper<T>> {

            private T object;
            private int priority;

            public IntPriorityComparableWrapper( T object, int priority ) {
                    this.object = object;
                    this.priority = priority;
            }

            public int compareTo( IntPriorityComparableWrapper<T> anotherObject ) {
                    return this.priority - anotherObject.priority;
            }

            public int getPriority() {
                    return priority;
            }

            public T getObject() {
                    return object;
            }
    }
}
