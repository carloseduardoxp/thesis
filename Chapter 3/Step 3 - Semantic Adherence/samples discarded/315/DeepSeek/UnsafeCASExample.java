import java.lang.reflect.Field;
import sun.misc.Unsafe;

public class UnsafeCASExample {
    private static final Unsafe unsafe = getUnsafe();
    private static final long valueOffset;
    
    private volatile int value;
    
    static {
        try {
            valueOffset = unsafe.objectFieldOffset(
                UnsafeCASExample.class.getDeclaredField("value"));
        } catch (Exception ex) { throw new Error(ex); }
    }
    
    public boolean compareAndSet(int expect, int update) {
        return unsafe.compareAndSwapInt(this, valueOffset, expect, update);
    }
    
    private static Unsafe getUnsafe() {
        // This is just for demonstration - getting Unsafe is tricky
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            return (Unsafe) f.get(null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
