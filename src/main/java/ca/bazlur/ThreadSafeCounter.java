package ca.bazlur;

public final class ThreadSafeCounter implements Counter {
    private int value = 0;

    @Override
    public synchronized void increment() {
        ++value;
    }

    @Override
    public synchronized int get() {
        return value;
    }
}
