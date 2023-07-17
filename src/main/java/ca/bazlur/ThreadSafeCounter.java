package ca.bazlur;

public class ThreadSafeCounter implements Counter{
    private int value = 0;
    @Override
    public synchronized int increment() {
        return ++value;
    }

    @Override
    public synchronized int get() {
        return value;
    }
}
