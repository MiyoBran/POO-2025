// ListaCircular.java
package carlosfontela.colecciones;

import java.util.*;

public class ListaCircular extends LinkedList {
	
	public Iterator iterator( ) {
		return new IteradorListaCircular(this);
	}
	
}
