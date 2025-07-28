import java.lang.reflect.*;

public class Example {
  public static void main(String[] args) {
    try {
      // Get the Class object representing the class to instantiate
      Class<?> clazz = Class.forName("com.example.MyClass");

      // Create a new instance of the class using the default constructor
      Object obj = clazz.newInstance();

      // Cast the object to the desired type
      MyClass myObj = (MyClass)obj;

      // Call a method on the object
      myObj.doSomething();
    } catch (ClassNotFoundException | IllegalAccessException | InstantiationException ex) {
      // Handle any exceptions that might occur
      ex.printStackTrace();
    }
  }
}
