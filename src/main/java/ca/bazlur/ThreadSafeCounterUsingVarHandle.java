package ca.bazlur;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

public class ThreadSafeCounterUsingVarHandle implements Counter {

    private final static VarHandle VAR_HANDLE;

    static {
        try {
            VAR_HANDLE = MethodHandles.lookup().findVarHandle(ThreadSafeCounterUsingVarHandle.class, "value", int.class);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new Error(e);
        }
    }

    private volatile int value = 0;

    @Override
    public int increment() {
        return (int) VAR_HANDLE.getAndAdd(this, 1);
    }

    @Override
    public int get() {
        return value;
    }
}
