import sun.misc.Unsafe;
import java.lang.reflect.Field;

public class UnsafeCasExample {
    private volatile int value = 0; // 'volatile' ensures visibility across threads

    // How to get an instance of Unsafe (highly discouraged!)
    private static Unsafe getUnsafe() {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            return (Unsafe) f.get(null);
        } catch (Exception e) {
            throw new RuntimeException("Could not get Unsafe instance", e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Unsafe unsafe = getUnsafe();
        UnsafeCasExample instance = new UnsafeCasExample();

        // Get the memory offset of the 'value' field
        long valueOffset;
        try {
            valueOffset = unsafe.objectFieldOffset(UnsafeCasExample.class.getDeclaredField("value"));
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }

        // Try to increment the value using CAS in a loop
        // This simulates a common pattern in non-blocking algorithms
        int NUM_THREADS = 10;
        int INCREMENTS_PER_THREAD = 100000;
        Thread[] threads = new Thread[NUM_THREADS];

        long startTime = System.nanoTime();

        for (int i = 0; i < NUM_THREADS; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < INCREMENTS_PER_THREAD; j++) {
                    int currentVal;
                    do {
                        currentVal = instance.value; // Read current value
                        // Atomically try to set value to currentVal + 1
                        // If currentVal is still the same, succeed.
                        // Otherwise, loop again.
                    } while (!unsafe.compareAndSwapInt(instance, valueOffset, currentVal, currentVal + 1));
                }
            });
            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }

        long endTime = System.nanoTime();

        System.out.println("Final value: " + instance.value);
        System.out.println("Expected value: " + (NUM_THREADS * INCREMENTS_PER_THREAD));
        System.out.println("Time taken: " + (endTime - startTime) / 1_000_000.0 + " ms");
    }
}