// Casa.java

package tp2.ej2.inmobiliarias;

public class Casa extends Inmueble {

		private boolean garage;
		private boolean jardin;
		private boolean pileta;
		private int superficieTerreno;

		public Casa(String domicilio, double superficie, int cantidadAmbientes, int precio,
				boolean garage, boolean jardin, boolean pileta, int superficieTerreno) {
			// llama al constructor de Inmueble:
			super (domicilio, superficie, cantidadAmbientes, precio);
			this.garage = garage;
			this.jardin = jardin;
			this.pileta = pileta;
			this.superficieTerreno = superficieTerreno;
		}

		public boolean getGarage( ) {
			return garage;
		}

		public boolean getJardin( ) {
			return jardin;
		}

		public boolean getPileta( ) {
			return pileta;
		}

		public int getSuperficieTerreno( ) {
			return superficieTerreno;
		}

		public void imprimirDatos( ) {
			// llama al ImprimirDatos de Inmueble:
			super.imprimirDatos( );
			// sigue imprimiendo sus propios datos:
			System.out.println ("Garage: " + getGarage( ));
			System.out.println ("Jard�n: " + getJardin( ));
			System.out.println ("Pileta: " + getPileta( ));
			System.out.println ("Superficie terreno: " + getSuperficieTerreno( ));
		}
}
