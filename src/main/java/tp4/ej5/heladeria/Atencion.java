package tp4.ej5.heladeria;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Atencion implements Runnable {
	private final Buffer colaAtencion;
	private final String nombre;
	private final ConcurrentLinkedQueue<Cliente> atendidos;
	private long totalWorkTimeMillis = 0;
	private int servedCount = 0;
	private final long minServiceMillis;
	private final long maxServiceMillis;
	
	public Atencion(Buffer colaAtencion, String nombre, ConcurrentLinkedQueue<Cliente> atendidos, long minServiceMillis, long maxServiceMillis) {
		this.colaAtencion = colaAtencion;
		this.nombre = nombre;
		this.atendidos = atendidos;
		this.minServiceMillis = minServiceMillis;
		this.maxServiceMillis = maxServiceMillis;
	}

	@Override
	public void run() {
		try {
			while (true) {
				Cliente cliente = colaAtencion.set();
				if (cliente == null) {
					// timeout -> no more clients
					System.out.println("Atención " + nombre + ": no hay más clientes (timeout). Saliendo.");
					break;
				}
				System.out.println("Atención " + nombre + " atendiendo al cliente " + cliente.getId());
				long start = System.currentTimeMillis();
				long sleep = minServiceMillis + (long)(Math.random() * (maxServiceMillis - minServiceMillis));
				Thread.sleep(sleep);
				long elapsed = System.currentTimeMillis() - start;
				totalWorkTimeMillis += elapsed;
				cliente.setSalida(System.currentTimeMillis());
				atendidos.add(cliente);
				servedCount++;
				System.out.println("Atención " + nombre + " completó al cliente " + cliente.getId() + ". Tiempo cliente en heladería: " + (cliente.getSalida() - cliente.getIngreso()) + " ms");
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			System.out.println("Atención " + nombre + " interrumpida.");
		}
	}

	public long getTotalWorkTimeMillis() {
		return totalWorkTimeMillis;
	}

	public int getServedCount() {
		return servedCount;
	}

	public String getNombre() {
		return nombre;
	}

}