// Singleton pattern ensures that a class has only one instance and provides a global point of access to it.
// This is useful when exactly one object is needed to coordinate actions across the system.

// There are several ways to implement the Singleton pattern in Java.
// This example demonstrates the "lazy initialization with double-checked locking" approach,
// which is thread-safe and performs well.

public class Singleton {

    // 1. Private static instance variable:
    // This holds the single instance of the Singleton class.
    // It's declared 'volatile' to ensure that multiple threads handle the 'instance' variable correctly
    // when it is being initialized to the Singleton instance. Without 'volatile',
    // the JVM might reorder operations, leading to issues in multi-threaded environments.
    private static volatile Singleton instance;

    // 2. Private constructor:
    // This prevents direct instantiation of the Singleton class from outside.
    // It ensures that only the Singleton class itself can create instances.
    private Singleton() {
        // Optional: Add a check here to prevent reflection-based instantiation
    }

    // 3. Public static method to get the instance:
    // This is the global access point to the single instance.
    // It implements the double-checked locking mechanism for thread safety and lazy initialization.
    public static Singleton getInstance() {
        // First check: Without locking, to avoid synchronization overhead if instance is already created.
        if (instance == null) {
            // Synchronized block: Ensures only one thread can enter this block at a time
            // when the instance is being created.
            synchronized (Singleton.class) {
                // Second check: Inside the synchronized block, to ensure that if multiple threads
                // pass the first check, only one actually creates the instance.
                if (instance == null) {
                    instance = new Singleton(); // Instance creation
                }
            }
        }
        return instance;
    }

    // Optional: Add methods specific to your Singleton's functionality
    public void showMessage() {
        System.out.println("Hello from the Singleton instance!");
    }

    // Example of how to use the Singleton
    public static void main(String[] args) {
        // Get the single instance of the Singleton class
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        // Verify that both references point to the same instance
        System.out.println("Are singleton1 and singleton2 the same instance? " + (singleton1 == singleton2));

        // Call a method on the Singleton instance
        singleton1.showMessage();
        singleton2.showMessage(); // Will call the method on the exact same instance
    }
}
