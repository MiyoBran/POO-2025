// ComparadorAlfabetico.java
package carlosfontela.pruebas;

import carlosfontela.inmobiliarias.*;

public class ComparadorAlfabetico implements CommandComparador {

	public boolean comparador(Inmueble x, Inmueble y) {
		return x.getDomicilio( ).compareTo(y.getDomicilio( )) > 0;
	}
}
