// ComparadorSuperficie.java
package carlosfontela.pruebas;

import carlosfontela.inmobiliarias.*;

public class ComparadorSuperficie implements CommandComparador {

	public boolean comparador(Inmueble x, Inmueble y) {
		return x.getSuperficie( ) < y.getSuperficie( );
	}
}
