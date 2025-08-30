// Poligono.java

package carlosfontela.geometria;

import java.util.*;

public class Poligono implements Figura {


	private List contorno;

	public Poligono (Punto[ ] contorno) {
		if (contorno.length < 3)
			throw new IllegalArgumentException( );
		this.contorno = new ArrayList (contorno.length);
		for (Punto p : contorno)
			this.contorno.add(p);
	}

	static protected double areaTrapecio (Punto p1, Punto p2) {
		return ( p1.getY() + p2.getY() ) * ( p2.getX() - p1.getX() ) / 2;
	}

	public int getNumeroLados ( ) {
			return contorno.size();
	}

	public double getArea ( ) {
		double superficie =
			areaTrapecio ( (Punto)contorno.get(getNumeroLados()-1),
									(Punto)contorno.get(0) );
		for (int i = 0; i < getNumeroLados()-1; i++)
			superficie += areaTrapecio ( (Punto)contorno.get(i),
								(Punto)contorno.get(i+1) );
		return superficie;
	}

	public double getPerimetro ( ) {
		double longitud =
			( (Punto)contorno.get(getNumeroLados()-1)).distancia ( (Punto)contorno.get(0));
		for (int i=0; i < getNumeroLados()-1; i++)
			longitud += ( (Punto)contorno.get(i)).distancia ( (Punto)contorno.get(i+1));
		return longitud;
	}

	private Segmento getLado (int i) {
		if (i < getNumeroLados()-1)
			return new Segmento ( (Punto)contorno.get(i), (Punto)contorno.get(i+1));
		else return new Segmento ( (Punto)contorno.get(i), (Punto)contorno.get(0));
	}

	// verifica si es un pol�gono con todos sus lados iguales
	public boolean isRegular ( ) {
		for (int i = 0; i < getNumeroLados()-1; i++)
			if ( getLado(i).getLongitud() != getLado(i+1).getLongitud() )
				return false;
		return true;
	}

	public String getTipo ( ) {
		if ( getNumeroLados() == 3 && isRegular() )
			return "tri�ngulo equil�tero";
		if ( getNumeroLados() == 4 && isRegular() )
			return "cuadrado";
		String nombre = null;
		switch ( getNumeroLados() ) {
			case 3 : nombre = "tri�ngulo"; break;
			case 4 : nombre = "cuadril�tero"; break;
			case 5 : nombre = "pent�gono"; break;
			case 6 : nombre = "hex�gono"; break;
			case 7 : nombre = "hept�gono"; break;
			case 8 : nombre = "oct�gono"; break;
			case 9 : nombre = "non�gono"; break;
			case 10 : nombre = "dec�gono"; break;
			case 12 : nombre = "dodec�gono"; break;
			case 20 : nombre = "icos�gono"; break; 
			default : nombre = "sin nombre"; break;
		}
		if ( isRegular() )
			nombre += " regular";
		return nombre;
	}

	public void trasladar (double deltaX, double deltaY) {
		Iterator i = contorno.iterator();
		while ( i.hasNext() ) {
			Punto p = (Punto)i.next();
			p.trasladar (deltaX, deltaY);
		}
	}

}
