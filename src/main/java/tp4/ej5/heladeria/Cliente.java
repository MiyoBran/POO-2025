package tp4.ej5.heladeria;

public class Cliente {
	private int id;
	private long ingreso;
	private long salida;
	
	public Cliente(int id) {
		this.id = id;
		this.ingreso = System.currentTimeMillis();
	}
	
	public int getId() {
		return id;
	}
	
	public long getIngreso() {
		return ingreso;
	}
	
	public long getSalida() {
		return salida;
	}
	
	public void setSalida(long salida) {
		this.salida = salida;
	}

}