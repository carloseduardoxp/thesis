public class Root<T> {

    T value;

    public Root(Class<T> klass) throws InstantiationException, IllegalAccessException {
        value = klass.newInstance();
    }

}
