package ca.bazlur;

/**
 * The Counter interface represents a simple counter.
 * It provides methods to increment the counter and retrieve its value.
 */
public interface Counter {

    /**
     * Increments the value of the counter by one.
     * @return the new value of the counter after the increment.
     */
    int increment();

    /**
     * Retrieves the current value of the counter.
     * @return the current value of the counter.
     */
    int get();
}