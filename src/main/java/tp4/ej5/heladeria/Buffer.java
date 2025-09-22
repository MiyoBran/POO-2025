package tp4.ej5.heladeria;

public interface Buffer {
	public void get(Cliente cliente) throws InterruptedException;
	public Cliente set() throws InterruptedException;

}
