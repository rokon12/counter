package ca.bazlur;

import java.util.concurrent.locks.StampedLock;

public final class CounterWithStampLock implements Counter {
    private int counter = 0;
    private final StampedLock lock = new StampedLock();

    @Override
    public void increment() {
        long stamp = lock.writeLock(); // Lock for writing
        try {
            counter++;
        } finally {
            lock.unlockWrite(stamp); // Unlock write lock
        }
    }

    @Override
    public int get() {
        long stamp = lock.tryOptimisticRead(); // Get optimistic read lock
        int tmpCounter = counter;
        // Verify that no write occurred after getting the optimistic read lock
        if (!lock.validate(stamp)) {
            stamp = lock.readLock(); // Fallback to read lock if a write occurred
            try {
                tmpCounter = counter;
            } finally {
                lock.unlockRead(stamp); // Unlock read lock
            }
        }
        return tmpCounter;
    }
}
