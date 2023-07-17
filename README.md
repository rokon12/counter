# Thread-Safe Counter In Java

## Description

This repository contains multiple implementations of a thread-safe counter, accompanied by a complete benchmarking suite to compare their performance. It was created to test modern concurrency features in Java and compare different concurrent counter strategies.

The different counter implementations include:

- Simple
- Java volatile
- Unsafe
- VarHandle
- Lock
- AtomicInteger

## Requirements

- Java SDK version 17
- IntelliJ IDEA 
- Maven (for managing dependencies and build configuration)

## Usage

Clone the repository and open it in IntelliJ IDEA. The main class `CounterTest` runs and measures the performance of all counter implementations under varied concurrent load.

## Experiment

JMH (Java Microbenchmark Harness) is used in creating benchmarks. Multiple threads try to increment each counter implementation concurrently. This provides a realistic gauge on the performance of each implementation under stress.

## License

Just smile! :)

## Collaboration

Pull requests for additional counter strategies or improved benchmarks are warmly welcome.