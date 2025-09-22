package tp4.ej5.heladeria;

public class Caja implements Runnable {
	private final Buffer colaCaja;
	private final Buffer colaAtencion;
	private final String nombre;
	private long totalWorkTimeMillis = 0;
	private int servedCount = 0;
	private final long minServiceMillis;
	private final long maxServiceMillis;
	
	public Caja(Buffer colaCaja, Buffer colaAtencion, String nombre, long minServiceMillis, long maxServiceMillis) {
		this.colaCaja = colaCaja;
		this.colaAtencion = colaAtencion;
		this.nombre = nombre;
		this.minServiceMillis = minServiceMillis;
		this.maxServiceMillis = maxServiceMillis;
	}
	
	@Override
	public void run() {
		try {
			Cliente cliente;
			while ((cliente = colaCaja.set()) != null) {
				System.out.println("La " + this.nombre + " atiende al cliente " + cliente.getId());
				long start = System.currentTimeMillis();
				long sleep = minServiceMillis + (long)(Math.random() * (maxServiceMillis - minServiceMillis));
				Thread.sleep(sleep);
				long elapsed = System.currentTimeMillis() - start;
				totalWorkTimeMillis += elapsed;
				servedCount++;
				
				colaAtencion.get(cliente);
				System.out.println("El cliente " + cliente.getId() + " fue atendido por la " + this.nombre);
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
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