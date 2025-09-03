package tp4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class HiloPrueba {
  public static void main (String[] args) {
    Hilo hilo1 = new Hilo();
    Hilo hilo2 = new Hilo();

    ExecutorService executor = Executors.newCachedThreadPool();

    executor.execute(hilo1);
    executor.execute(hilo2);

    executor.shutdown();

    try {
        boolean tareasTerminaron = executor.awaitTermination(1, TimeUnit.SECONDS);
        if (tareasTerminaron) {
            System.out.println("Terminaron todos los Hilos");
        }else
            System.out.println("No terminaron todos los Hilos");
    } catch (InterruptedException e) {
      System.out.println("Hilo principal interrumpido");
    }
    System.out.println("Hilos finalizados");
  }
}
