package tp4.ej5.heladeria;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;


public class Cola implements Buffer{
	private final ArrayBlockingQueue<Cliente> buffer;
	private final long pollTimeoutMillis;

	public Cola(int size) {
		this(size, 20000);
	}

	public Cola(int size, long pollTimeoutMillis) {
		this.buffer = new ArrayBlockingQueue<>(size);
		this.pollTimeoutMillis = pollTimeoutMillis;
	}
	
	@Override
	public void get(Cliente cliente) throws InterruptedException {
		buffer.put(cliente);
	}
	
	// wait up to pollTimeoutMillis and return null if timeout
	@Override
	public Cliente set() throws InterruptedException {
		return buffer.poll(pollTimeoutMillis, TimeUnit.MILLISECONDS);
	}

}