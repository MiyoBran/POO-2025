// Punto.java
package carlosfontela.geometria;

/**
 * Esta clase implementa un punto en dos dimensiones.
 * 
 * @author Carlos Fontela
 * @version 3.0
 */
public class Punto {

	private double coordX;
	private double coordY;

	/**
	 * Constructor de los objetos de clase Punto.
	 *
	 * @param  x   valor para la coordenada x
	 * @param  y   valor para la coordenada y
	 */
	public Punto (double x, double y) {
		coordX = x;
		coordY = y;
	}

	/**
	 * Devuelve la coordenada en x.
	 * 
	 * @return     la coordenada en x.
	 */
	public double getX( ) {
			return coordX;
	}

	/**
	 * Cambia la coordenada en x.
	 * 
	 * @param  valor   nuevo valor para la coordenada x
	 */
	public void setX (double valor) {
			coordX = valor;
	}

	/**
	 * Devuelve la coordenada en y.
	 * 
	 * @return     la coordenada en y.
	 */
	public double getY( ) {
			return coordY;
	}

	/**
	 * Cambia la coordenada en y.
	 * 
	 * @param  valor   nuevo valor para la coordenada y
	 */
	public void setY (double valor) {
			coordY = valor;
	}

	/**
	 * Traslada un punto.
	 * 
	 * @param  deltaX  incremento en la coordenada x
	 * @param  deltaY  incremento en la coordenada y
	 */
	public void trasladar (double deltaX, double deltaY) {
		coordX += deltaX;
		coordY += deltaY;
	}

	/**
	 * Calcula la distancia respecto de otro punto.
	 * 
	 * @param  otro  el otro punto
	 * @return      distancia entre los puntos.
	 */
	public double distancia (Punto otro) {
		return Math.sqrt
			( Math.pow((coordX-otro.coordX),2) +
					Math.pow((coordY-otro.coordY),2) );
	}
	
	/**
	 * Convierte en String.
	 * 
	 * @return      La representación en cadena de caracteres de un punto.
	 */
	public String toString( ) {
		return new Double(getX( )).toString( ) + ";" + new Double(getY( )).toString( );
	}
}
