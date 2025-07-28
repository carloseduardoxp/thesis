import sun.misc.Unsafe;
import java.lang.reflect.Field;

public class UnsafeCasExample {
    private static final Unsafe unsafe;
    private static final long valueOffset;

    private volatile int value = 0;

    static {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            unsafe = (Unsafe) f.get(null);
            valueOffset = unsafe.objectFieldOffset(UnsafeCasExample.class.getDeclaredField("value"));
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    public boolean compareAndSwap(int expected, int newValue) {
        return unsafe.compareAndSwapInt(this, valueOffset, expected, newValue);
    }

    public static void main(String[] args) {
        UnsafeCasExample example = new UnsafeCasExample();
        System.out.println("CAS successful? " + example.compareAndSwap(0, 42));
        System.out.println("New value: " + example.value);
    }
}
