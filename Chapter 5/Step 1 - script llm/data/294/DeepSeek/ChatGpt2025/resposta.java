import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class DynamicClasspathLoader {
    public static void main(String[] args) {
        // Path to JAR file
        String jarPath = "path/to/your/external.jar";
        
        try {
            // Add to classpath
            addToClassPath(jarPath);
            
            // Now you can load classes normally
            Class<?> clazz = Class.forName("com.yourpackage.YourClass");
            Object instance = clazz.getDeclaredConstructor().newInstance();
            
            // Call a method
            Method method = clazz.getMethod("yourMethod");
            method.invoke(instance);
        } catch (DynamicClasspathLoaderException e) {
            e.printStackTrace();
            // Handle or rethrow as appropriate
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
            // Handle or rethrow as appropriate
        }
    }
    
    private static void addToClassPath(String jarPath) throws DynamicClasspathLoaderException {
        try {
            URLClassLoader classLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
            Method addUrl = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
            addUrl.setAccessible(true);
            addUrl.invoke(classLoader, new URL("file:" + jarPath));
        } catch (Exception e) {
            throw new DynamicClasspathLoaderException("Failed to add JAR to classpath: " + jarPath, e);
        }
    }

    public static class DynamicClasspathLoaderException extends Exception {
        public DynamicClasspathLoaderException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
