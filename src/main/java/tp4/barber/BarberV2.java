package tp4.barber;

import java.util.concurrent.TimeUnit;

public class BarberV2 implements Runnable {
    private final BshopV2 shop;
    private final long pollTimeout;
    private final TimeUnit pollUnit;

    public BarberV2(BshopV2 shop, long pollTimeout, TimeUnit pollUnit) {
        this.shop = shop;
        this.pollTimeout = pollTimeout;
        this.pollUnit = pollUnit;
    }

    @Override
    public void run() {
        System.out.println("BarberV2 started");
        while (shop.isOpen()) {
            shop.cutHairWithTimeout(pollTimeout, pollUnit);
        }
        System.out.println("BarberV2: shop closed, finishing work.");
    }
}

