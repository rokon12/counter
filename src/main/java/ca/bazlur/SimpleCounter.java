package ca.bazlur;

public class SimpleCounter implements Counter {
    private int value = 0;

    @Override
    public int increment() {
        return ++value;
    }

    @Override
    public int get() {
        return value;
    }
}
