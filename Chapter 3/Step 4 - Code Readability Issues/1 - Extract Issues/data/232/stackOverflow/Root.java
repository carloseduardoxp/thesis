public class Root<T> {

    T var;

    public Root(Class<T> klass) {
        var = klass.newInstance();
    }

}