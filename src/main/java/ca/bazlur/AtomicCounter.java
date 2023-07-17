package ca.bazlur;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter  implements Counter{
    AtomicInteger counter = new AtomicInteger();
    @Override
    public int increment() {
        return counter.incrementAndGet();
    }

    @Override
    public int get() {
        return counter.get();
    }
}

