package tp4.ej6.taxi;

public class Pasajero implements Runnable {
	private int id;
	private static int cantPasajeros = 0;
	private ParadaTaxi parada;
	// Distancia que recorre el pasajero en cuadras
	private int distancia;
	
	public Pasajero(ParadaTaxi parada, int distancia) {
		cantPasajeros++;
		this.id = cantPasajeros;
		this.parada = parada;
		this.distancia = distancia;
	}

	@Override
	public void run() {
		// Llegar a la parada y esperar hasta timeout configurado
		try {
			boolean boarded = parada.llegar(this);
			if (!boarded) {
				System.out.println("Pasajero " + id + " no consiguió taxi y se retira");
			} else {
				System.out.println("Pasajero " + id + " viaja en taxi");
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			// minimal logging
			e.printStackTrace();
		}
	}

	public int getId() {
		return id;
	}
	
	public int getDistancia() {
		return distancia;
	}
	
	public static int getCantPasajeros() {
		return cantPasajeros;
	}

}