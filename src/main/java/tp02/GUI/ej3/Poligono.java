// Poligono.java
package tp02.GUI.ej3;

import java.awt.Color;
import java.awt.Graphics;

public class Poligono extends Figura {

	private Punto[ ] contorno;
  private Color color;

	public Poligono (Punto[ ] contorno) {
		if (contorno.length < 3)
			// veremos el significado de lo que sigue en un cap�tulo posterior:
			throw new IllegalArgumentException( );
		this.contorno = contorno;
    this.color = Color.BLACK;
	}

	static protected double areaTrapecio (Punto p1, Punto p2) {
		return (p1.getY( ) + p2.getY( )) * (p2.getX( ) - p1.getX( )) / 2;
	}

	public int numeroLados( ) {
		return contorno.length;
	}

  // Metodo Abstracto de la consigna para cambiar el color.
  @Override
  public void setColor(Color color) {
    this.color = color;
  }

  @Override
  public void dibujar(Graphics g) {
    g.setColor(color);
    int n = contorno.length;
    int[] xPoints = new int[n];
    int[] yPoints = new int[n];
    for (int i = 0; i < n; i++) {
      xPoints[i] = (int) contorno[i].getX();
      yPoints[i] = (int) contorno[i].getY();
    }
    g.drawPolygon(xPoints, yPoints, n);
  }

	public double area ( ) {
		double superficie =
			areaTrapecio (contorno [numeroLados( )-1], contorno[0]);
		for (int i = 0; i < numeroLados( )-1; i++)
			superficie += areaTrapecio (contorno[i], contorno[i+1]);
		return superficie;
	}

	public double perimetro ( ) {
		double longitud = contorno[numeroLados( )-1].distancia (contorno[0]);
		for (int i=0; i<numeroLados( )-1; i++)
			longitud += contorno[i].distancia (contorno[i+1]);
		return longitud;
	}

	private Segmento lado (int i) {
		if (i < numeroLados( )-1)
			return new Segmento (contorno[i], contorno[i+1]);
		else return new Segmento (contorno[i], contorno[0]);
	}

	// verifica si es un poligono con todos sus lados iguales
	public boolean regular( ) {
		for (int i = 0; i < contorno.length-1; i++) {
			if (lado(i).getLongitud( ) != lado(i+1).getLongitud( ))
				return false;
		}
		return true;
	}

	public String tipo( ) {
		if (numeroLados( ) == 3 && regular( ))
			return "triangulo equilatero";
		if (numeroLados( ) == 4 && regular( ))
			return "cuadrado";
		String nombre = null;
		switch (numeroLados( )) {
			case 3 : nombre = "triangulo"; break;
			case 4 : nombre = "cuadrilatero"; break;
			case 5 : nombre = "pentagono"; break;
			case 6 : nombre = "hexagono"; break;
			case 7 : nombre = "heptagono"; break;
			case 8 : nombre = "octagono"; break;
			case 9 : nombre = "nonagono"; break;
			case 10 : nombre = "decagono"; break;
			case 12 : nombre = "dodecagono"; break;
			case 20 : nombre = "icosagono"; break;
			default : nombre = "sin nombre";
		}
		if (regular( ))
			nombre += " regular";
		return nombre;
	}

	public void trasladar (double deltaX, double deltaY) {
		for (int i = 0; i < contorno.length; i++)
			contorno[i].trasladar (deltaX, deltaY);
	}

}
