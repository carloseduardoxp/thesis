import java.lang.reflect.InvocationTargetException;

class InstanceCreationException extends RuntimeException {
    public InstanceCreationException(String message, Throwable cause) {
        super(message, cause);
    }
}

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
            throw new InstanceCreationException("Error creating instance of " + type.getName(), e);
        }
    }

    public static void main(String[] args) {
        // Create a factory for String
        GenericFactory<String> stringFactory = new GenericFactory<>(String.class);
        String myString = stringFactory.createInstance();
        System.out.println("Created String: " + myString); // Output: Created String: 

        // Create a factory for Integer
        try {
            GenericFactory<Integer> integerFactory = new GenericFactory<>(Integer.class);
            integerFactory.createInstance();
        } catch (InstanceCreationException e) {
            System.out.println("Caught expected exception for Integer: " + e.getMessage());
        }

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
