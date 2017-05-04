package ch1.s4;

public class Stopwatch {

    private final long start;

    public Stopwatch() {
        start = System.currentTimeMillis();
    }

    public double elapsed() {
        return (System.currentTimeMillis() - start ) / 1000.0;
    }
}
