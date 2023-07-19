package ca.bazlur;

/**
 * The Counter interface represents a simple counter.
 * It provides methods to increment the counter and retrieve its value.
 */
public sealed interface Counter permits
        AtomicCounter, LongAdderCounter, ThreadSafeCounter,
        ThreadSafeCounterUsingLock, ThreadSafeCounterUsingVarHandle {
    /**
     * Increments the value of the counter by one.
     */
    void increment();

    /**
     * Retrieves the current value of the counter.
     * @return the current value of the counter.
     */
    int get();
}