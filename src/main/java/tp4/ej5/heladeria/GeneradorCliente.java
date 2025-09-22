package tp4.ej5.heladeria;

public class GeneradorCliente implements Runnable {
	private Buffer buffer;
	private int cantClientes;
	private final long minArrivalMillis;
	private final long maxArrivalMillis;
	
	public GeneradorCliente(Buffer buffer, int cantClientes, long minArrivalMillis, long maxArrivalMillis) {
		this.buffer = buffer;
		this.cantClientes = cantClientes;
		this.minArrivalMillis = minArrivalMillis;
		this.maxArrivalMillis = maxArrivalMillis;
	}

	@Override
	public void run() {
		for (int i = 0; i < cantClientes; i++) {
			Cliente cliente = new Cliente(i+1);
			try {
				buffer.get(cliente);
				System.out.println("Cliente " + cliente.getId() + " ingresó a la heladería.");
				long sleep = minArrivalMillis + (long)(Math.random() * (maxArrivalMillis - minArrivalMillis));
				Thread.sleep(sleep); // Simula tiempo entre llegadas de clientes
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				System.out.println("Generador de clientes interrumpido.");
			}
		}
	}

}