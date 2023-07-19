package ca.bazlur;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

/**
  * This class is a benchmark for different implementations of a counter.
 * It measures the performance of incrementing and getting the value of a counter using different implementations.
 *
 * <p>The class is annotated with various benchmarking annotations to specify the benchmarking mode, output time unit,
 * warm-up and measurement iterations, number of forks, and number of threads.
 *
 * <p>The class contains private methods for incrementing and getting the counter value one million times.
 *
 * <p>The class contains benchmark methods for incrementing and getting the counter value using different implementations.
 * Each benchmark method is annotated with the @Benchmark annotation.
 *
 * <p>The class also defines instance variables for different counter implementations, which are initialized in the setup() method.
 *
 * @see Counter
 * @see ThreadSafeCounter
 * @see ThreadSafeCounterUsingVarHandle
 * @see ThreadSafeCounterUsingLock
 * @see AtomicCounter
 * @see LongAdderCounter
 */

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
@Warmup(iterations = 5, time = 1)
@Measurement(iterations = 5, time = 1)
@Fork(3)
@Threads(50)
public class CounterBenchmark {
  private Counter threadsafeCounter;
  private Counter threadSafeUsingVarHandle;
  private Counter threadSafeUsingLock;
  private Counter atomicCounter;
  private Counter longAdderCounter;

  @Setup
  public void setup() {
    threadsafeCounter = new ThreadSafeCounter();
    threadSafeUsingVarHandle = new ThreadSafeCounterUsingVarHandle();
    threadSafeUsingLock = new ThreadSafeCounterUsingLock();
    atomicCounter = new AtomicCounter();
    longAdderCounter = new LongAdderCounter();
  }

  private void incrementOneMillionTimes(Counter counter) {
    for (int i = 0; i < 1_000_000; i++) {
      counter.increment();
    }
  }

  private void getOneMillionTimes(Counter counter) {
    for (int i = 0; i < 1_000_000; i++) {
      counter.get();
    }
  }

  @Benchmark
  public void incrementWithThreadSafeCounter() {
    incrementOneMillionTimes(threadsafeCounter);
  }

  @Benchmark
  public void getWithThreadSafeCounter() {
    getOneMillionTimes(threadsafeCounter);
  }

  @Benchmark
  public void incrementWithThreadSafeCounterUsingVarHandle() {
    incrementOneMillionTimes(threadSafeUsingVarHandle);
  }

  @Benchmark
  public void getWithThreadSafeCounterUsingVarHandle() {
    getOneMillionTimes(threadSafeUsingVarHandle);
  }

  @Benchmark
  public void incrementWithThreadSafeCounterUsingLock() {
    incrementOneMillionTimes(threadSafeUsingLock);
  }

  @Benchmark
  public void getWithThreadSafeCounterUsingLock() {
    getOneMillionTimes(threadSafeUsingLock);
  }

  @Benchmark
  public void incrementAtomicInteger() {
    incrementOneMillionTimes(atomicCounter);
  }

  @Benchmark
  public void getWithAtomicInteger() {
    getOneMillionTimes(atomicCounter);
  }

  @Benchmark
  public void incrementWithLongAdder() {
    incrementOneMillionTimes(longAdderCounter);
  }

  @Benchmark
  public void getWithLongAdder() {
    getOneMillionTimes(longAdderCounter);
  }
}