package tp4.ej6.taxi;

public interface BufferTaxi {
	public void get(Taxi taxi) throws InterruptedException;
	public Taxi set() throws InterruptedException;

}
