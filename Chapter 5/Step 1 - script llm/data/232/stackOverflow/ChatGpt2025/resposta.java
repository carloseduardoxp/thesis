public class Root<T> {

    T value;

    public Root(Class<T> klass) {
        value = klass.newInstance();
    }

}