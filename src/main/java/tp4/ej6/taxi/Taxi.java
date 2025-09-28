package tp4.ej6.taxi;

public class Taxi implements Runnable {
	private int id;
	private ParadaTaxi parada;
	private static int cantTaxis = 0;
	// current passenger assigned to this taxi
	private Pasajero pasajeroActual = null;
	private volatile boolean running = true;
	private final long msPorCuadra;
	private final double returnMultiplier;
	// count of passengers transported by this taxi
	private int pasajerosTransportados = 0;

	public Taxi(ParadaTaxi parada, long msPorCuadra, double returnMultiplier) {
		cantTaxis++;
		this.id = cantTaxis;
		this.parada = parada;
		this.msPorCuadra = msPorCuadra;
		this.returnMultiplier = returnMultiplier;
	}

	@Override
	public void run() {
		try {
			while (running) {
				// arrive to parada and wait for passenger
				parada.get(this);
				System.out.println("Taxi " + id + " esperando pasajero");
				// Wait until a passenger is assigned via subirPasajero
				Pasajero p = null;
				synchronized (this) {
					while (pasajeroActual == null && running) {
						wait();
					}
					if (!running) break;
					p = pasajeroActual;
					pasajeroActual = null; // consume
				}
				if (p == null) break;
				// increment counters
				pasajerosTransportados++;
				Metrics.incrementServed();
				System.out.println("Taxi " + id + " recogiendo pasajero " + p.getId());
				// travel time based on passenger distance: msPorCuadra per block
				long travelTime = p.getDistancia() * msPorCuadra;
				Thread.sleep(travelTime);
				System.out.println("Taxi " + id + " pasajero " + p.getId() + " dejado");
				// return time is travelTime * returnMultiplier
				long returnTime = (long) (travelTime * returnMultiplier);
				Thread.sleep(returnTime);
				System.out.println("Taxi " + id + " volvió a la parada");
			}
		} catch (InterruptedException e) {
			// interruption used for shutdown; restore interrupt status
			Thread.currentThread().interrupt();
		}
		System.out.println("Taxi " + id + " finalizando. Pasajeros transportados: " + pasajerosTransportados);
	}

	public synchronized void subirPasajero(Pasajero p) {
		this.pasajeroActual = p;
		notify();
	}

	public void shutdown() {
		running = false;
		// print message on shutdown with transported count
		System.out.println("Shutdown solicitado para Taxi " + id + ". Pasajeros transportados: " + pasajerosTransportados);
		// Wake up if waiting for passenger
		synchronized (this) {
			notify();
		}
	}

	public int getId() {
		return id;
	}
	
	public static int getCantTaxis() {
		return cantTaxis;
	}

}