# Thread-Safe Counter In Java

## Description

This repository contains multiple implementations of a thread-safe counter, accompanied by a complete benchmarking suite to compare their performance. It was created to test modern concurrency features in Java and compare different concurrent counter strategies.

The different counter implementations include:

- Simple (without synchronization)
- Java Synchronized
- Unsafe
- VarHandle
- ReentrantLock
- AtomicInteger

## Requirements

- Java SDK version 17
- IntelliJ IDEA 
- Maven (for managing dependencies and build configuration)

## Usage

Clone the repository and open it in IntelliJ IDEA. The main class `CounterTest` runs and measures the performance of all counter implementations under varied concurrent load.

## Results

The counter implementations show different results when run on `CounterTest`. Here are the results:

### SimpleCounter

Final Counter Value: 196699615  
Expected Counter Value: 200000000  
Time Taken: 0.028589333 seconds

### ThreadSafeCounter

Final Counter Value: 200000000  
Expected Counter Value: 200000000  
Time Taken: 19.807858875 seconds

### ThreadSafeCounterUsingUnsafe

Final Counter Value: 200000000  
Expected Counter Value: 200000000  
Time Taken: 12.420408125 seconds

### ThreadSafeCounterUsingVarHandle

Final Counter Value: 200000000  
Expected Counter Value: 200000000  
Time Taken: 12.605674958 seconds

### ThreadSafeCounterUsingLock

Final Counter Value: 200000000  
Expected Counter Value: 200000000  
Time Taken: 4.110033459 seconds

### AtomicCounter

Final Counter Value: 200000000  
Expected Counter Value: 200000000  
Time Taken: 13.654771916 seconds

![img.png](img.png)


Please note that these results may vary based on the system and the current CPU workload.



## Experiment

JMH (Java Microbenchmark Harness) is used in creating benchmarks. Multiple threads try to increment each counter implementation concurrently. This provides a realistic gauge on the performance of each implementation under stress.

## License

Just smile! :)

## Collaboration

Pull requests for additional counter strategies or improved benchmarks are warmly welcome.