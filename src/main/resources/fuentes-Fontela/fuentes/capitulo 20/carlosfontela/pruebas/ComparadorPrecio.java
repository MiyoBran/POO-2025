// ComparadorPrecio.java
package carlosfontela.pruebas;

import carlosfontela.inmobiliarias.*;

public class ComparadorPrecio implements CommandComparador {

	public boolean comparador(Inmueble x, Inmueble y) {
		return x.getPrecio( ) < y.getPrecio( );
	}
}
