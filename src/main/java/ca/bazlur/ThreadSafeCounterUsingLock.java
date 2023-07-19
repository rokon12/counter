package ca.bazlur;

import java.util.concurrent.locks.*;

public final class ThreadSafeCounterUsingLock implements Counter {
    private final Lock lock = new ReentrantLock();
    private int value = 0;

    @Override
    public void increment() {
        lock.lock();
        try {
            ++value;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public int get() {
        lock.lock();
        try {
            return value;
        } finally {
            lock.unlock();
        }
    }
}
