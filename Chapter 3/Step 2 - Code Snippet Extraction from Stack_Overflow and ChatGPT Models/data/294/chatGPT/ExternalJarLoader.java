import java.net.URL;
import java.net.URLClassLoader;

public class ExternalJarLoader {

    public static void main(String[] args) throws Exception {
        // Define the URL of the external JAR file
        URL url = new URL("file:/path/to/external.jar");

        // Create a new URLClassLoader with the external JAR file URL as the classpath
        URLClassLoader classLoader = new URLClassLoader(new URL[] { url });

        // Load a custom class from the external JAR file
        Class<?> customClass = classLoader.loadClass("com.example.CustomClass");

        // Create a new instance of the custom class
        Object customObject = customClass.newInstance();

        // Call a method on the custom class instance
        customClass.getMethod("doSomething").invoke(customObject);
    }
}
