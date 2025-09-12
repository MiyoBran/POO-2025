package tp4.barber;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Bshop versión 2: buffer con ArrayBlockingQueue y poll() para consumidor.
 */
public class BshopV2 {
    private final int capacity;
    private final ArrayBlockingQueue<CustomerV2> queue;
    private volatile boolean open = true;

    public BshopV2(int capacity) {
        this.capacity = capacity;
        this.queue = new ArrayBlockingQueue<>(capacity);
    }

    public boolean isOpen() {
        return open;
    }

    /**
     * Consumidor: intenta obtener cliente con timeout. Si no llega ninguno
     * dentro del tiempo, cierra la barbería.
     */
    public void cutHairWithTimeout(long timeout, TimeUnit unit) {
        CustomerV2 customer = null;
        System.out.println("Barber waiting for customer (poll with timeout)...");
        try {
            customer = queue.poll(timeout, unit);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            System.out.println("Barber interrupted while polling.");
            return;
        }

        if (customer == null) {
            System.out.println("No customers arrived in time. Closing the shop.");
            open = false;
            return;
        }

        long duration = (long) (Math.random() * 5) + 1; // 1-5s
        try {
            System.out.println("Cutting hair of " + customer.getName());
            TimeUnit.SECONDS.sleep(duration);
            System.out.println("Finished cutting " + customer.getName() + " in " + duration + "s");
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            System.out.println("Barber interrupted while cutting.");
        }
    }

    /**
     * Productor: intenta agregar sin bloquear. Devuelve true si se agregó.
     */
    public boolean addCustomer(CustomerV2 c) {
        if (!open) {
            System.out.println("Shop is closed. Customer " + c.getName() + " leaves.");
            return false;
        }
        boolean added = queue.offer(c);
        if (!added) {
            System.out.println("No chair available for customer " + c.getName() + ". Customer leaves.");
        } else {
            System.out.println("Customer " + c.getName() + " got a chair.");
        }
        return added;
    }
}
