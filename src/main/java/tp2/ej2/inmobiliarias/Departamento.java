// Departamento.java
package tp2.ej2.inmobiliarias;

public class Departamento extends Inmueble {

		private boolean cochera;
		private boolean baulera;

		public Departamento (String domicilio, double superficie, int cantidadAmbientes,
 								int precio, boolean cochera, boolean baulera) {
			// llama al constructor de Inmueble:
			super (domicilio, superficie, cantidadAmbientes, precio);
			this.cochera = cochera;
			this.baulera = baulera;
		}

		public boolean getCochera( ) {
			return cochera;
		}

		public boolean getBaulera( ) {
			return baulera;
	}

		public void imprimirDatos( ) {
			// llama al ImprimirDatos de Inmueble:
			super.imprimirDatos( );
			// sigue imprimiendo sus propios datos:
			System.out.println ("Cochera: " + getCochera( ));
			System.out.println ("Baulera: " + getBaulera( ));
		}
}
