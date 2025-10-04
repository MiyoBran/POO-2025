package tp4.ej6.taxi;

import java.util.concurrent.ThreadLocalRandom;

public class GeneradorPasajeros implements Runnable {
    private ParadaTaxi parada;
    private int cantPasajeros;
    private final int minCuadras;
    private final int maxCuadras;
    private final long interArrivalMinMillis;
    private final long interArrivalMaxMillis;
    private volatile boolean running = true;

    public GeneradorPasajeros(ParadaTaxi parada, int cantPasajeros, int minCuadras, int maxCuadras,
            long interArrivalMinMillis, long interArrivalMaxMillis) {
        this.parada = parada;
        this.cantPasajeros = cantPasajeros;
        this.minCuadras = minCuadras;
        this.maxCuadras = maxCuadras;
        this.interArrivalMinMillis = interArrivalMinMillis;
        this.interArrivalMaxMillis = interArrivalMaxMillis;
    }

    @Override
    public void run() {
        for (int i = 0; i < cantPasajeros && running; i++) {
            int distancia = ThreadLocalRandom.current().nextInt(minCuadras, maxCuadras + 1);
            Pasajero pasajero = new Pasajero(parada, distancia);
            Thread hiloPasajero = new Thread(pasajero);
            hiloPasajero.start();
            try {
                long sleep = ThreadLocalRandom.current().nextLong(interArrivalMinMillis, interArrivalMaxMillis + 1);
                Thread.sleep(sleep); // breve intervalo entre llegadas
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    public void shutdown() {
        running = false;
    }
}