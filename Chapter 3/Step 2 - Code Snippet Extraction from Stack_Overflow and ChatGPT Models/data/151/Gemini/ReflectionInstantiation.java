import java.lang.reflect.InvocationTargetException;

public class ReflectionInstantiation {

    public static void main(String[] args) {
        String className = "MyClass"; // Replace with your class's fully qualified name
        try {
            // 1. Get the Class object
            Class<?> clazz = Class.forName(className);

            // 2. Instantiate the object using the no-argument constructor
            Object obj = clazz.getDeclaredConstructor().newInstance();

            // 3. Cast to the actual class type if known, or work with Object
            if (obj instanceof MyClass) {
                MyClass myObject = (MyClass) obj;
                myObject.sayHello();
            } else {
                System.out.println("Instantiated object of type: " + obj.getClass().getName());
            }

        } catch (ClassNotFoundException e) {
            System.err.println("Class not found: " + className);
            e.printStackTrace();
        } catch (InstantiationException e) {
            System.err.println("Error instantiating class (abstract class, interface, or no no-arg constructor): " + e.getMessage());
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            System.err.println("Illegal access (constructor is not public): " + e.getMessage());
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            System.err.println("No no-argument constructor found: " + e.getMessage());
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            System.err.println("Exception thrown by the constructor: " + e.getTargetException().getMessage());
            e.printStackTrace();
        }
    }
}

// Example class with a no-argument constructor
class MyClass {
    public MyClass() {
        System.out.println("MyClass no-arg constructor called.");
    }

    public void sayHello() {
        System.out.println("Hello from MyClass!");
    }
}
