import java.lang.reflect.Method;
import java.net.*;

public class Teste {

    public void main() throws Exception {
        URLClassLoader child = new URLClassLoader(new URL[] { myJar.toURL() }, this.getClass().getClassLoader());
        Class<?> classToLoad = Class.forName("com.MyClass", true, child);
        Method method = classToLoad.getDeclaredMethod("myMethod");
        Object instance = classToLoad.getDeclaredConstructor().newInstance();
        method.invoke(instance);
    }
}