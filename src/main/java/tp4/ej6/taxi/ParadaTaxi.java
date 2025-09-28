package tp4.ej6.taxi;

public class ParadaTaxi {
	private BufferTaxi buffer;
	

	public ParadaTaxi(BufferTaxi buffer) {
		this.buffer = buffer;
	}

	public void llegar(Pasajero pasajero) throws InterruptedException {
		System.out.println("Pasajero " + pasajero.getId() + " llegando a la parada de taxis");
		Taxi taxi = buffer.set();
		System.out.println("Pasajero " + pasajero.getId() + " subiendo al taxi " + taxi.getId());
	}

	public void get(Taxi taxi) {
		// TODO Auto-generated method stub
		try {
			buffer.get(taxi);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
