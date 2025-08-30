// PilaGenerica.java

package carlosfontela.colecciones;

import java.util.*;

public class PilaGenerica <E> implements Pila<E> {

	private Stack<E> implementacion;
	
	public PilaGenerica( ) {
		this.implementacion = new Stack<E>( );
	}
	
	public void agregar (E x) {
		implementacion.add(x);
	}

	public E extraer( ) throws PilaVaciaException {
		try {
			return implementacion.pop( );
		}
		catch (EmptyStackException e) {
			throw new PilaVaciaException( );
		}
	}

	public E tope( ) throws PilaVaciaException {
		try {
			return implementacion.peek( );
		}
		catch (EmptyStackException e) {
			throw new PilaVaciaException( );
		}
	}

	public void eliminar( ) throws PilaVaciaException {
		try {
			implementacion.pop( );
		}
		catch (EmptyStackException e) {
			throw new PilaVaciaException( );
		}
	}

	public boolean vacia( ) {
		return (implementacion.size( ) == 0);
	}

	public void vaciar( ) {
		implementacion.clear( );
	}

	public int cardinalidad( ) {
		return implementacion.size( );
	}
}
