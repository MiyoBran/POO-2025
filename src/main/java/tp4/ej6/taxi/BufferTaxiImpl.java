package tp4.ej6.taxi;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Buffer implementation for taxis using ArrayBlockingQueue.
 * - get(Taxi): taxi arrives at the parada and is enqueued (blocks if buffer full)
 * - set(): passenger asks for a taxi; waits up to configured timeout for a taxi, returns null on timeout
 */
public class BufferTaxiImpl implements BufferTaxi {
    private final ArrayBlockingQueue<Taxi> queue;
    private final long timeoutMillis;

    public BufferTaxiImpl(int capacidad, long timeoutMillis) {
        this.queue = new ArrayBlockingQueue<>(capacidad);
        this.timeoutMillis = timeoutMillis;
    }

    @Override
    public void get(Taxi taxi) throws InterruptedException {
        // block until space available
        queue.put(taxi);
    }

    @Override
    public Taxi set() throws InterruptedException {
        // wait up to configured timeout for a taxi
        return queue.poll(timeoutMillis, TimeUnit.MILLISECONDS);
    }
}