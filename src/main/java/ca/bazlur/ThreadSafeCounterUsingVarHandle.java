package ca.bazlur;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

public final class ThreadSafeCounterUsingVarHandle implements Counter {
    private volatile int value = 0;

    @Override
    public void increment() {
        VALUE.getAndAdd(this, 1);
    }

    @Override
    public int get() {
        return value;
    }

    private final static VarHandle VALUE;

    static {
        try {
            VALUE = MethodHandles.lookup().findVarHandle(
                    ThreadSafeCounterUsingVarHandle.class, "value", int.class);
        } catch (ReflectiveOperationException e) {
            throw new Error(e);
        }
    }
}
