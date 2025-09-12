package tp4.barber;

import java.util.concurrent.TimeUnit;

public class CustomerGeneratorV2 implements Runnable {
    private final BshopV2 shop;
    private final int maxCustomers; // 0 para infinito

    public CustomerGeneratorV2(BshopV2 shop, int maxCustomers) {
        this.shop = shop;
        this.maxCustomers = maxCustomers;
    }

    @Override
    public void run() {
        int count = 0;
        while (shop.isOpen() && (maxCustomers == 0 || count < maxCustomers)) {
            count++;
            CustomerV2 c = new CustomerV2("CustomerV2-" + count);
            shop.addCustomer(c);

            // dormir entre 1 y 3 segundos
            long sleep = 1 + (long) (Math.random() * 3);
            try {
                TimeUnit.SECONDS.sleep(sleep);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                System.out.println("CustomerGeneratorV2 interrupted, stopping.");
                break;
            }
        }
        System.out.println("CustomerGeneratorV2 finished generating customers.");
    }
}

