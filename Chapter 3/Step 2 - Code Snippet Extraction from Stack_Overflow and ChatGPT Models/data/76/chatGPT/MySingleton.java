public class MySingleton {
    private static MySingleton instance;

    private MySingleton() {
        // Private constructor to prevent creation of new instances from outside the class
    }

    public static MySingleton getInstance() {
        if (instance == null) {
            instance = new MySingleton();
        }
        return instance;
    }

    // Other methods and variables of the class go here
}
