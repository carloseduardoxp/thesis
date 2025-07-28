import java.net.URL;
import java.net.URLClassLoader;
import java.lang.reflect.Method;

public class JarLoader {
    public static void main(String[] args) {
        try {
            // Path to your external JAR file
            String jarPath = "/path/to/external.jar";
            URL jarUrl = new URL("file://" + jarPath);

            // Create a URLClassLoader to load the classes from the JAR
            URLClassLoader classLoader = new URLClassLoader(new URL[] { jarUrl });

            // Load a class from the JAR by name
            Class<?> clazz = classLoader.loadClass("com.example.CustomClass");

            // Instantiate the class
            Object instance = clazz.getDeclaredConstructor().newInstance();

            // Call a method from the loaded class using reflection
            Method method = clazz.getMethod("someMethod");
            method.invoke(instance);

            // Close the class loader
            classLoader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
