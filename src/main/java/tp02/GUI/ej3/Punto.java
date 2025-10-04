// Punto.java

package tp02.GUI.ej3;

public class Punto {

		// atributos:
		private double coordX;
		private double coordY;

		// constructor:
		public Punto (double x, double y) {
			coordX = x;
			coordY = y;
		}

		// propiedades de lectura y escritura:

		public double getX( ) {
			return coordX;
		}

		public void setX (double valor) {
			coordX = valor;
		}

		public double getY( ) {
			return coordY;
		}

		public void setY (double valor) {
			coordY = valor;
		}

		// m�todos:

		public void trasladar (double deltaX, double deltaY) {
			coordX += deltaX;
			coordY += deltaY;
		}

		public double distancia (Punto otro) {
			return Math.sqrt
				( Math.pow((coordX-otro.coordX),2) +
					Math.pow((coordY-otro.coordY),2) );
		}

  public String toString() {
    return getX() + ";" + getY();
  }
}
