import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class DynamicJarLoader {

    public static void main(String[] args) {
        String jarPath = "path/to/your-custom-library.jar"; // Replace with actual path
        String className = "com.yourcompany.customlib.MyCustomClass"; // Fully qualified class name

        try {
            // 1. Convert the JAR file path to a URL
            File file = new File(jarPath);
            URL url = file.toURI().toURL();

            // 2. Create a new URLClassLoader with the JAR's URL
            // It's often good practice to set the parent classloader to the system classloader
            URLClassLoader classLoader = new URLClassLoader(new URL[]{url}, ClassLoader.getSystemClassLoader());

            // 3. Load the custom class using the new class loader
            Class<?> customClass = classLoader.loadClass(className);

            // 4. Create an instance of the custom class (requires a no-arg constructor or specific constructor handling)
            Object instance = customClass.getDeclaredConstructor().newInstance();

            // 5. Invoke a method on the custom class instance using Reflection
            // Assuming MyCustomClass has a method like: public void doSomething(String message)
            Method method = customClass.getDeclaredMethod("doSomething", String.class);
            method.invoke(instance, "Hello from dynamic loading!");

            System.out.println("Successfully loaded and invoked method from: " + jarPath);

            // Close the classloader (important for resource management, though complex with parent loaders)
            // In Java 7+, URLClassLoader implements Closeable
            if (classLoader != null) {
                try {
                    classLoader.close();
                } catch (IOException e) {
                    System.err.println("Error closing classloader: " + e.getMessage());
                }
            }

        } catch (MalformedURLException e) {
            System.err.println("Invalid JAR path: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Class not found in JAR: " + className + " - " + e.getMessage());
        } catch (NoSuchMethodException e) {
            System.err.println("Method not found in class: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}