package ca.bazlur;

public class ThreadSafeCounterUsingUnsafe implements Counter {
    private static final sun.misc.Unsafe UNSAFE;
    private static final long valueOffset;

    static {
        try {
            var field = sun.misc.Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            UNSAFE = (sun.misc.Unsafe) field.get(null);
            valueOffset = UNSAFE.objectFieldOffset(ThreadSafeCounterUsingUnsafe.class.getDeclaredField("value"));
            System.out.println("Offset: " + valueOffset);
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    private volatile int value = 0;


    @Override
    public int increment() {
        return 1 + UNSAFE.getAndAddInt(this, valueOffset, 1);
    }

    @Override
    public int get() {
        return value;
    }
}
