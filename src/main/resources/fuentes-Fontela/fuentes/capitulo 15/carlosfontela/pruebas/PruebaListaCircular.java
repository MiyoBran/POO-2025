package carlosfontela.pruebas;

import java.util.*;
import carlosfontela.colecciones.*;

public class PruebaListaCircular {

	public static void main (String[ ] p) {

		ListaCircular lista = new ListaCircular( );
		for (int x = 0; x < 10; x++)
			lista.add(x);
		
		Iterator i = lista.iterator( );
		int k = 0;	// contador
		while (i.hasNext( )) {
			k++;	// para salir del ciclo en algún momento
			if (k > 1000) break;
			System.out.println(i.next( ));
		}
	}
}
