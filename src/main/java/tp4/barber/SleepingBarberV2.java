package tp4.barber;

import java.util.concurrent.TimeUnit;

public class SleepingBarberV2 {
    public static void main(String[] args) {
        int capacity = 3; // sillas de espera (antes era 3)
        long pollTimeout = 5; // segundos que espera el barbero sin clientes

        BshopV2 shop = new BshopV2(capacity);

        BarberV2 barber = new BarberV2(shop, pollTimeout, TimeUnit.SECONDS);
        CustomerGeneratorV2 gen1 = new CustomerGeneratorV2(shop, 24);
        CustomerGeneratorV2 gen2 = new CustomerGeneratorV2(shop, 24);
        CustomerGeneratorV2 gen3 = new CustomerGeneratorV2(shop, 24);

        Thread tBarber = new Thread(barber, "BarberV2-Thread");
        Thread tGen1 = new Thread(gen1, "CustomerGeneratorV2-1");
        Thread tGen2 = new Thread(gen2, "CustomerGeneratorV2-2");
        Thread tGen3 = new Thread(gen3, "CustomerGeneratorV2-3");

        tBarber.start();
        tGen1.start();
        tGen2.start();
        tGen3.start();

        try {
            // esperar a que terminen los generadores
            tGen1.join();
            tGen2.join();
            tGen3.join();
            // luego esperar a que el barbero cierre la barbería
            tBarber.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("SleepingBarberV2: simulation finished.");
    }
}
