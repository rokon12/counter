package ca.bazlur;

import java.util.*;

/**
  * The CounterTest class is responsible for running various counter implementations and measuring their performance.
 *
 * The class contains a main method that initializes and runs the counter implementations. It also prints the final
 * counter value, the expected counter value, and the time taken for each counter implementation.
 *
 * To run the counter implementations, the runCounter method is called with an instance of each counter implementation.
 * The runCounter method creates multiple threads and increments the counter in each thread. After all threads have
 * completed, it prints the final counter value, the expected counter value, and the time taken.
 */

public class CounterTest {
  private static final int NUM_THREADS = 200; // Number of threads
  private static final int NUM_INCREMENTS = 1_000_000; // Number of increments per thread

  public static void main(String[] args) throws InterruptedException,
          ReflectiveOperationException {
    for (Class<?> clazz : Counter.class.getPermittedSubclasses()) {
        var subclazz = clazz.asSubclass(Counter.class);
        var constructor = subclazz.getConstructor();
        runCounter(constructor.newInstance());
    }
  }

  private static void runCounter(Counter counter) throws InterruptedException {
    var threads = new ArrayList<Thread>();

    long start = System.nanoTime();

    for (int i = 0; i < NUM_THREADS; i++) {
      var thread =
          new Thread(
              () -> {
                for (int j = 0; j < NUM_INCREMENTS; j++) {
                  counter.increment();
                }
              });
      threads.add(thread);
      thread.start();
    }

    for (var thread : threads) {
      thread.join(); // Wait for thread to complete
    }

    long end = System.nanoTime();

    System.out.println(
        "Final counter value on " + counter.getClass().getSimpleName() + ": " + counter.get());

    System.out.println("Expected counter value: " + (NUM_THREADS * NUM_INCREMENTS));
    System.out.println("Time taken: " + (end - start) / 1e9 + " seconds");
    System.out.println("--------------------------------------------------");
    System.out.println();
  }
}
