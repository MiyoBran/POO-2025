// IteradorListaCircular.java
package carlosfontela.colecciones;

import java.util.*;

public class IteradorListaCircular implements IteradorCircular {

	private ListaCircular lista;
	private int indiceActual;
	private boolean primeraVueltaCompleta;
	
	public IteradorListaCircular (ListaCircular lista) {
		this.lista = lista;
		this.indiceActual = 0;
		this.primeraVueltaCompleta = false;
	}

	public boolean hasNext( ) {
		if (lista.size( ) > 0)
			return true;
		else return false;
	}

	public Object next( ) {
		Object resultado = null;
		if ( lista.isEmpty() )
			throw new UnsupportedOperationException( );
		resultado = lista.get(indiceActual);
		if (indiceActual < lista.size( )-1)
			indiceActual++;
		else {
			indiceActual = 0;
			primeraVueltaCompleta = true;
		}
		return resultado;
	}

	public void remove( ) {
		throw new UnsupportedOperationException( );
	}

	public boolean primeraVueltaCompleta( ) {
		return primeraVueltaCompleta;
	}
}
