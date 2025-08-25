// Pila.java

package carlosfontela.colecciones;

public interface Pila <E> {
	void agregar (E x);
	E extraer( ) throws PilaVaciaException;
	E tope( ) throws PilaVaciaException;
	void eliminar( ) throws PilaVaciaException;
	boolean vacia( );
	void vaciar( );
	int cardinalidad( );
}
