package tp4.ej6.taxi;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Simple metrics collector for the taxi simulation.
 */
public class Metrics {
    private static final AtomicInteger timedOut = new AtomicInteger(0);
    private static final AtomicInteger served = new AtomicInteger(0);

    public static void incrementTimedOut() {
        timedOut.incrementAndGet();
    }

    public static void incrementServed() {
        served.incrementAndGet();
    }

    public static int getTimedOut() {
        return timedOut.get();
    }

    public static int getServed() {
        return served.get();
    }
}
