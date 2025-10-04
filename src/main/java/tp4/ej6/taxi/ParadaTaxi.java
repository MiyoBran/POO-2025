package tp4.ej6.taxi;

public class ParadaTaxi {
	private BufferTaxi buffer;
	

	public ParadaTaxi(BufferTaxi buffer) {
		this.buffer = buffer;
	}

	public boolean llegar(Pasajero pasajero) throws InterruptedException {
		System.out.println("Pasajero " + pasajero.getId() + " llegando a la parada de taxis");
		// Try to get a taxi from the buffer (waits up to the buffer implementation timeout)
		Taxi taxi = buffer.set();
		if (taxi == null) {
			System.out.println("Pasajero " + pasajero.getId() + " esperó y no consiguió taxi, se retira");
			Metrics.incrementTimedOut();
			return false;
		}
		System.out.println("Pasajero " + pasajero.getId() + " subiendo al taxi " + taxi.getId());
		// Assign the passenger to the taxi and wake it
		taxi.subirPasajero(pasajero);
		return true;
	}

	public void get(Taxi taxi) {
		// taxi arrives to the parada and is added to the buffer
		try {
			buffer.get(taxi);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			// keep minimal logging for debugging
			e.printStackTrace();
		}
		
	}
	

}