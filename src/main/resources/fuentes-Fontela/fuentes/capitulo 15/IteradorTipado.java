import java.util.*;

public class IteradorTipado implements Iterator {

	private Iterator implementacion;
	private Class tipo;		// la clase Class la estudiaremos en otro cap�tulo

	public IteradorTipado (Iterator i, Class t) {
		implementacion = i;
		tipo = t;
	}

	public boolean hasNext ( ) {
		return implementacion.hasNext( );
	}

	public Object next( ) {
		Object o = implementacion.next( );
		if (!tipo.isInstance(o))
			throw new ClassCastException ("iterador tipado como "+ tipo +
									" encontr� el tipo: " + o.getClass( ));
		return o;
	}

	public void remove ( ) {
		throw new UnsupportedOperationException( );
	}
}
