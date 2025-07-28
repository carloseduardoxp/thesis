public class MyGenericClass<T> {
    private Class<T> clazz;

    public MyGenericClass(Class<T> clazz) {
        this.clazz = clazz;
    }

    public T createInstance() throws IllegalAccessException, InstantiationException {
        return clazz.newInstance(); // Deprecated but works for simple cases
    }
}
