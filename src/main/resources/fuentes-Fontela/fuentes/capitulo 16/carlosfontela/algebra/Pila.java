package carlosfontela.algebra;

import java.util.*;

public class Pila <E> {

	private List<E> elementos;

	public Pila ( ) {
		elementos = new ArrayList<E>();
	}

	public boolean vacia ( ) {
		return elementos.isEmpty();
	}
	
	public void agregar (E nuevoElemento) {
		elementos.add(nuevoElemento);
	}

	public E sacar ( ) {
		if (vacia( ))
			throw new UnsupportedOperationException( );
		E resultado = elementos.get(elementos.size()-1);
		elementos.remove(elementos.size()-1);
		return resultado;
	}

}

