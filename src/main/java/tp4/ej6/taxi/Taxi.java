package tp4.ej6.taxi;

public class Taxi implements Runnable {
	private int id;
	private ParadaTaxi parada;

	public Taxi(int id, ParadaTaxi parada) {
		this.id = id;
		this.parada = parada;
	}

	@Override
	public void run() {
		try {
			while (true) {
				parada.get(this);
				System.out.println("Taxi " + id + " recogiendo pasajero");
				Thread.sleep((long) (Math.random() * 1000));
				System.out.println("Taxi " + id + " pasajero dejado");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public int getId() {
		return id;
	}

}
