// Departamento.java
package carlosfontela.inmobiliarias;

public class Departamento extends Inmueble {

	private boolean cochera;
	private boolean baulera;
	
	public Departamento (String domicilio, double superficie, int cantidadAmbientes, int precio,
 				boolean cochera, boolean baulera)
		throws InmuebleInvalidoException {
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
		super.imprimirDatos( );
		System.out.println ("Cochera: " + getCochera( ));
		System.out.println ("Baulera: " + getBaulera( ));
	}

	// nuevo método:
	public double comisionVendedor( ) {
		if (getCochera( ))
			return 0.009 * getPrecio( );
		else return 0.011 * getPrecio( );
	}
}
