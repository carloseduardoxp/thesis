import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class DynamicClasspathLoader {

    public static class ClasspathAdditionException extends Exception {
        public ClasspathAdditionException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static void main(String[] args) throws ClasspathAdditionException, ReflectiveOperationException, ClassNotFoundException {
        // Path to JAR file
        String jarPath = "path/to/your/external.jar";
        
        // Add to classpath
        addToClassPath(jarPath);
        
        // Now you can load classes normally
        Class<?> clazz = Class.forName("com.yourpackage.YourClass");
        Object instance = clazz.getDeclaredConstructor().newInstance();
        
        // Call a method
        Method method = clazz.getMethod("yourMethod");
        method.invoke(instance);
    }
    
    private static void addToClassPath(String jarPath) throws ClasspathAdditionException {
        try {
            URLClassLoader classLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
            Method addUrl = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
            addUrl.setAccessible(true);
            addUrl.invoke(classLoader, new URL("file:" + jarPath));
        } catch (NoSuchMethodException | MalformedURLException | IllegalAccessException | InvocationTargetException e) {
            throw new ClasspathAdditionException("Failed to add JAR to classpath: " + jarPath, e);
        }
    }
}
