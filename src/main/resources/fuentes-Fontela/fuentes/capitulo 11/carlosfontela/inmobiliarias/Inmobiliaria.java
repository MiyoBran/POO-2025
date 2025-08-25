// Inmobiliaria.java
package carlosfontela.inmobiliarias;

public class Inmobiliaria {
		private String nombre;
		private int cantidadInmuebles;
		private final int maximoInmuebles = 100;
		private Inmueble[ ] inmuebles;

		public Inmobiliaria (String nombre) {
			this.nombre = nombre;
			this.inmuebles = null;
			this.cantidadInmuebles = 0;
		}
		
		public String getNombre( ) {
				return nombre;
		}

		public int getCantidadInmuebles( ) {
			return cantidadInmuebles;
		}

		public void agregarInmueble (Inmueble x) {
			if (cantidadInmuebles == maximoInmuebles) {
				System.out.println("Se superó el máximo de inmuebles para esta inmobiliaria");
				return;
			}
			if (inmuebles == null)
				inmuebles = new Inmueble[maximoInmuebles];
			inmuebles [cantidadInmuebles] = x;
			cantidadInmuebles++;
		}

		private int posicionInmueble (Inmueble x) {
			if (inmuebles == null)
				return -1;
			for (int pos = 0; pos < cantidadInmuebles; pos++)
				if (inmuebles[pos] == x)
					return pos;
			return -1;
		}

		public void quitarInmueble (Inmueble x) {
			int pos = posicionInmueble (x);
			if (pos > -1) {	// encontró el inmueble
				// voy a eliminar el elemento del arreglo por compresión
				for (int i = pos; i < cantidadInmuebles-1; i++) {
					inmuebles[i] = inmuebles [i+1];
				}
				inmuebles [cantidadInmuebles-1] = null;
				cantidadInmuebles--;
			}
		}

		public void imprimirDatos ( ) {
			System.out.println ("Inmobiliaria: " + this.getNombre( ));
			if (inmuebles != null)
				for (int i = 0; i < cantidadInmuebles; i++)
					inmuebles[i].imprimirDatos( );
			System.out.println( );
		}
}
