import java.util.*;
public class Prueba3 {

		static Vector v;

		private static Vector cargar ( ) {
			v = new Vector( );
			for(int i = 0; i < 10; i++)
				((Vector)v).add(new Integer(i));
			return v;
		}

		private static void imprimir (Collection c) {
			// pido un iterador para la colecci�n c:
			Enumeration i = Collections.enumeration(v);	// v es de tipo Vector
			// recorro la colecci�n:
			while ( i.hasMoreElements( ) )
				System.out.println( (Integer) i.nextElement( ) );
		}

		public static void main (String [ ] p) {
			v = cargar( ); 	// ac� llen� el arreglo
			imprimir(v);
		}

}
