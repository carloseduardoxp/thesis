
import java.lang.reflect.Field;

public class Teste {

    
    public static void clearAllThreadLocals() {
        try {
            Field threadLocals = Thread.class.getDeclaredField("threadLocals");
            threadLocals.setAccessible(true);
            threadLocals.set(Thread.currentThread(), null);
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }
    
}