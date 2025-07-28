public class MySingleton {
    private static MySingleton instance;

    private MySingleton() {
        // private constructor to prevent instantiation
    }

    public static MySingleton getInstance() {
        if (instance == null) {
            instance = new MySingleton();
        }
        return instance;
    }
}
