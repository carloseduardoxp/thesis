
import java.lang.reflect.Method;
import java.net.*;

public class Teste {

    public void main() {
        URLClassLoader child = new URLClassLoader(myJar.toURL(), this.getClass().getClassLoader());
        Class classToLoad = Class.forName("com.MyClass", true, child);
        Method method = classToLoad.getDeclaredMethod("myMethod");
        Object instance = classToLoad.newInstance();
        Object result = method.invoke(instance);
    }
}
