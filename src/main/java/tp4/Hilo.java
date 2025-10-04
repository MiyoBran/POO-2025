package tp4;

public class Hilo implements Runnable {

  // constructor de los hilos
  public Hilo() {
  }


  @Override
  public void run() {

    try {
      for (int i = 0; i < 10; i++) {
        System.out.println("Hilo " + Thread.currentThread().getName() + " - Iteracion " + i);
        Thread.sleep(1000);
      }
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }


  }
}
