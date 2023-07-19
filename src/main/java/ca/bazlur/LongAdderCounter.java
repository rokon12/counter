package ca.bazlur;

import java.util.concurrent.atomic.*;

public final class LongAdderCounter implements Counter {
    private final LongAdder counter = new LongAdder();

    @Override
    public void increment() {
        counter.increment();
    }

    @Override
    public int get() {
        return counter.intValue();
    }
}

