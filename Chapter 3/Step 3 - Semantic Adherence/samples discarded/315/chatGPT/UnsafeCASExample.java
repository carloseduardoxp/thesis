import sun.misc.Unsafe;
import java.lang.reflect.Field;

public class UnsafeCASExample {
    private static final Unsafe unsafe = getUnsafe();
    private static final long valueOffset;

    private volatile int value = 0;

    static {
        try {
            valueOffset = unsafe.objectFieldOffset(UnsafeCASExample.class.getDeclaredField("value"));
        } catch (Exception ex) {
            throw new Error(ex);
        }
    }

    public boolean compareAndSet(int expectedValue, int newValue) {
        return unsafe.compareAndSwapInt(this, valueOffset, expectedValue, newValue);
    }

    private static Unsafe getUnsafe() {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(null);
        } catch (Exception ex) {
            throw new Error(ex);
        }
    }
}
