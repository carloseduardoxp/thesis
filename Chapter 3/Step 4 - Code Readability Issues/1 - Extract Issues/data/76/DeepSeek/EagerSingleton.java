public class EagerSingleton {
    // Private static instance created when class is loaded
    private static final EagerSingleton instance = new EagerSingleton();
    
    // Private constructor to prevent instantiation
    private EagerSingleton() {}
    
    // Public method to provide access to the instance
    public static EagerSingleton getInstance() {
        return instance;
    }
}
