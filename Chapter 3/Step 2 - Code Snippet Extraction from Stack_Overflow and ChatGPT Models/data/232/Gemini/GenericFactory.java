import java.lang.reflect.InvocationTargetException;

public class GenericFactory<T> {

    private Class<T> type;

    public GenericFactory(Class<T> type) {
        this.type = type;
    }

    public T createInstance() {
        try {
            // Use getDeclaredConstructor().newInstance() for modern Java (Java 9+)
            // type.newInstance() is deprecated as of Java 9
            return type.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException("Error creating instance of " + type.getName(), e);
        }
    }

    public static void main(String[] args) {
        // Create a factory for String
        GenericFactory<String> stringFactory = new GenericFactory<>(String.class);
        String myString = stringFactory.createInstance();
        System.out.println("Created String: " + myString); // Output: Created String: 

        // Create a factory for Integer
        GenericFactory<Integer> integerFactory = new GenericFactory<>(Integer.class);
        Integer myInteger = integerFactory.createInstance();
        System.out.println("Created Integer: " + myInteger); // Output: Created Integer: 0

        // Custom class example
        GenericFactory<MyObject> myObjectFactory = new GenericFactory<>(MyObject.class);
        MyObject obj = myObjectFactory.createInstance();
        obj.doSomething(); // Output: MyObject instance created!
    }
}

class MyObject {
    public MyObject() {
        System.out.println("MyObject constructor called.");
    }
    public void doSomething() {
        System.out.println("MyObject instance created!");
    }
}
