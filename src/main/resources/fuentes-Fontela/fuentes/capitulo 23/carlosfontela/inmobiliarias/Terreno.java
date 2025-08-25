// Terreno.java
package carlosfontela.inmobiliarias;

public class Terreno extends Inmueble {

		private boolean enEsquina;

		public Terreno (String domicilio, double superficie, int cantidadAmbientes,
 									int precio, boolean enEsquina) {
			// llama al constructor de Inmueble:
			super (domicilio, superficie, cantidadAmbientes, precio);
			this.enEsquina = enEsquina;
		}

		public boolean getEnEsquina( ) {
			return enEsquina;
		}

		public void imprimirDatos( ) {
			// llama al ImprimirDatos de Inmueble:
			super.imprimirDatos( );
			// sigue imprimiendo sus propios datos:
			System.out.println ("En esquina: " + getEnEsquina( ));
		}

		public double comisionVendedor( ) {
			return 0.01 * getPrecio( );
		}
}
