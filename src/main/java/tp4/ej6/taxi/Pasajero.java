package tp4.ej6.taxi;

public class Pasajero implements Runnable {
	private int id;
	private static int cantPasajeros = 0;
	//private ParadaTaxi parada;
	
	
	public Pasajero(int id) {
		cantPasajeros++;
		this.id = cantPasajeros;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Pasajero " + id + " llegando a la parada de taxis");
		// Simular que el pasajero llega a la parada de taxis
		try {
			Thread.sleep((long) (Math.random() * 1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	public int getId() {
		return id;
	}
	

}
