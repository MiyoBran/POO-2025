package tp4.ej6.taxi;

/* La parada tiene 5 taxis en el inicio , cuando llega un pasajero se sube al taxi y el taxi se va. Cuando 
 *	no hay taxis el pasajero espera un tiempo configurable.
 * Cuando un taxi vuelve a la parada, si hay pasajeros esperando, se sube un pasajero y el taxi se va.
 * Si no hay pasajeros esperando, el taxi espera en la parada.
 * El tardar del taxi en volver a la parada puede configurarse con returnMultiplier.
 * Cada pasajero recorre una distancia aleatoria entre minCuadras y maxCuadras cuadras.
 * Cada cuadra tarda msPorCuadra milisegundos en recorrerla.
 * El programa debe crear N taxis y M pasajeros.
 * 
 * */
public class EmpresaTaxiApp {
	public static void main(String[] args) throws InterruptedException {
		// Configurables
		final int CANT_TAXIS = 5;
		final int CANT_PASAJEROS = 20;
		final int MIN_CUADRAS = 10;
		final int MAX_CUADRAS = 100;
		final long MS_POR_CUADRA = 100; // tiempo por cuadra
		final double RETURN_MULTIPLIER = 2.0; // tiempo de regreso = travelTime * RETURN_MULTIPLIER
		
		// Compute inter-arrival window based on expected round-trip so arrivals are spaced
		double avgDistance = (MIN_CUADRAS + MAX_CUADRAS) / 2.0;
		long avgRoundTrip = (long) (avgDistance * MS_POR_CUADRA * (1.0 + RETURN_MULTIPLIER));
		// Aim to spread arrivals so each taxi can serve multiple passengers
		long INTER_ARRIVAL_MIN_MS = Math.max(100, avgRoundTrip / (CANT_TAXIS * 2));
		long INTER_ARRIVAL_MAX_MS = Math.max(INTER_ARRIVAL_MIN_MS + 100, avgRoundTrip / CANT_TAXIS);
		
		// Buffer timeout and shutdown grace derived from worst-case
		final long BUFFER_TIMEOUT_MS = 5000; // cuanto espera un pasajero por taxi
		final long SHUTDOWN_GRACE_PERIOD_MS = avgRoundTrip + 2000; // allow one worst-case round trip plus margin
	
		BufferTaxi buffer = new BufferTaxiImpl(CANT_TAXIS, BUFFER_TIMEOUT_MS);
		ParadaTaxi parada = new ParadaTaxi(buffer);
		
		// Crear y arrancar los hilos de los taxis
		Taxi[] taxis = new Taxi[CANT_TAXIS];
		Thread[] taxiThreads = new Thread[CANT_TAXIS];
		for (int i = 0; i < CANT_TAXIS; i++) {
			taxis[i] = new Taxi(parada, MS_POR_CUADRA, RETURN_MULTIPLIER);
			taxiThreads[i] = new Thread(taxis[i], "Taxi-" + (i+1));
			taxiThreads[i].start();
		}
		
		System.out.println("Inter-arrival window: [" + INTER_ARRIVAL_MIN_MS + "ms, " + INTER_ARRIVAL_MAX_MS + "ms], avgRoundTrip=" + avgRoundTrip + "ms");
		
		// Crear y arrancar el generador de pasajeros con parametros ajustables
		GeneradorPasajeros generador = new GeneradorPasajeros(parada, CANT_PASAJEROS,
			MIN_CUADRAS, MAX_CUADRAS, INTER_ARRIVAL_MIN_MS, INTER_ARRIVAL_MAX_MS);
		Thread hiloGenerador = new Thread(generador, "GeneradorPasajeros");
		hiloGenerador.start();
		
		// Esperar a que el generador termine de crear pasajeros
		hiloGenerador.join();
		System.out.println("Generador finalizó. Esperando gracia de " + SHUTDOWN_GRACE_PERIOD_MS + " ms para que taxis terminen viajes pendientes...");
		// Esperar un tiempo para que los taxis terminen los viajes en curso
		Thread.sleep(SHUTDOWN_GRACE_PERIOD_MS);
		
		// Solicitar shutdown a taxis
		for (Taxi t : taxis) {
			t.shutdown();
		}
		
		// Esperar a que terminen los hilos de taxis (sin timeout, garantizar que finalicen antes de imprimir resumen)
		for (Thread tt : taxiThreads) {
			if (tt != null) {
				try {
					tt.join();
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
		}
		
		// Print metrics summary AFTER taxis finished
		System.out.println("Resumen: pasajeros atendidos = " + Metrics.getServed() + ", pasajeros que se fueron sin taxi = " + Metrics.getTimedOut());
		
		System.out.println("EmpresaTaxiApp finalizado.");
	}

}