import java.util.*;
public class Prueba2 {

		static List v;

		private static List cargar ( ) {
			v = new ArrayList( );
			for(int i = 0; i < 10; i++)
				((ArrayList)v).add(new Integer(i));
			return v;
		}

		private static void imprimir (Collection c) {
			// pido un iterador para la colecci�n c:
			Iterator i = c.iterator( );
			// recorro la colecci�n:
			while( i.hasNext( ) )
				System.out.println ( i.next( ) );
		}

		public static void main (String [ ] p) {
			v = cargar( ); 	// ac� llen� el arreglo
			imprimir(v);
		}

}
