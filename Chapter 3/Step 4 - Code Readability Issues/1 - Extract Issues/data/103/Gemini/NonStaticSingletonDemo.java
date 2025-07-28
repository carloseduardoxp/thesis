// The class you want to be "singleton-like"
class MyNonStaticSingleton {
    private String name;

    // Private constructor to prevent direct instantiation
    private MyNonStaticSingleton(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// The "Container" or "Registry" class
class SingletonRegistry {
    private MyNonStaticSingleton instance;

    // This would typically be a static instance of the registry itself,
    // or you'd manage its lifecycle carefully.
    // For simplicity, let's assume this registry is managed externally.
    // In a real scenario, SingletonRegistry would likely be a Singleton itself.
    private static SingletonRegistry theRegistry = new SingletonRegistry();

    private SingletonRegistry() {
        // Initialize the non-static "singleton" here
        this.instance = new MyNonStaticSingleton("My Unique Instance");
    }

    public static MyNonStaticSingleton getInstance() {
        return theRegistry.instance;
    }
}

public class NonStaticSingletonDemo {
    public static void main(String[] args) {
        MyNonStaticSingleton s1 = SingletonRegistry.getInstance();
        MyNonStaticSingleton s2 = SingletonRegistry.getInstance();

        System.out.println(s1.getName());
        System.out.println(s2.getName());
        System.out.println("Are they the same object? " + (s1 == s2));
    }
}
