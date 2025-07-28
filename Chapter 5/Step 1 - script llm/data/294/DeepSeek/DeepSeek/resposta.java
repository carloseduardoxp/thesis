import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;

public class DynamicClasspathLoader {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, 
            IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        // Path to JAR file
        String jarPath = "path/to/your/external.jar";
        
        // Add to classpath
        try {
            addToClassPath(jarPath);
        } catch (MalformedURLException | IllegalAccessException | InvocationTargetException e) {
            throw new ClasspathLoadException("Failed to add JAR to classpath: " + jarPath, e);
        }
        
        // Now you can load classes normally
        Class<?> clazz = Class.forName("com.yourpackage.YourClass");
        Object instance = clazz.getDeclaredConstructor().newInstance();
        
        // Call a method
        Method method = clazz.getMethod("yourMethod");
        method.invoke(instance);
    }
    
    private static void addToClassPath(String jarPath) throws MalformedURLException, IllegalAccessException, InvocationTargetException {
        URLClassLoader classLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
        try {
            Method addUrl = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
            addUrl.setAccessible(true);
            addUrl.invoke(classLoader, new URL("file:" + jarPath));
        } catch (NoSuchMethodException e) {
            throw new ClasspathLoadException("Failed to access addURL method", e);
        }
    }
    
    private static class ClasspathLoadException extends RuntimeException {
        public ClasspathLoadException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
