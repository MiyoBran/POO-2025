// Terreno.java
package carlosfontela.inmobiliarias;

public class Terreno extends Inmueble {

	private boolean enEsquina;
	
	public Terreno (String domicilio, double superficie, int cantidadAmbientes,
 			int precio, boolean enEsquina)
	throws InmuebleInvalidoException {
		super (domicilio, superficie, cantidadAmbientes, precio);
		this.enEsquina = enEsquina;
	}
		
	public boolean getEnEsquina( ) {
		return enEsquina;
	}
	
	public void imprimirDatos( ) {
		super.imprimirDatos( );
		System.out.println ("En esquina: " + getEnEsquina( ));
	}

	// nuevo método:
	public double comisionVendedor( ) {
		return 0.01 * getPrecio( );
	}
}
