public class Punto {

	private int coordX;
	private int coordY;

	public Punto (int x, int y) {
		coordX = x;
		coordY = y;
	}

	public synchronized int x( ) {
		return coordX;
	}

	public synchronized int y( ) {
		return coordY;
	}

	public synchronized void cambiarXY(int x, int y) {
		coordX = x;
		coordY = y;
	}
}
