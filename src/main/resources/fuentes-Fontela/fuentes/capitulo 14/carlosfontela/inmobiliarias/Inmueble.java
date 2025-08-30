// Inmueble.java
package carlosfontela.inmobiliarias;

public abstract class Inmueble {

	private String domicilio;
	private double superficie;
	private int cantidadAmbientes;
	private int precio;
	private Notificable[ ] interesados;
	private int cantidadInteresados;
	private final int maximoInteresados = 1000;
	private boolean reservado;
	private boolean vendido;
		
public Inmueble (String domicilio, double superficie, int cantidadAmbientes, int precio)
		throws InmuebleInvalidoException {
	if ( superficie <= 0 || cantidadAmbientes < 1 || precio < 0)
		throw new InmuebleInvalidoException( );
	this.domicilio = domicilio;
	this.superficie = superficie;
	this.cantidadAmbientes = cantidadAmbientes;
	this.precio = precio;
	this.interesados = null;
	this.reservado = false;
	this.vendido = false;
}
		
	public String getDomicilio( ) {
			return domicilio;
	}
		
	public double getSuperficie( ) {
			return superficie;
	}
		
	public int getCantidadAmbientes( ) {
			return cantidadAmbientes;
	}
		
	public int getPrecio( ) {
		return precio;
	}
	
	public void setPrecio (int nuevo) throws InmuebleInvalidoException {
		if (nuevo < 0)
			throw new InmuebleInvalidoException( );
		precio = nuevo;
		if (interesados != null)
			for (int i = 0; i < cantidadInteresados; i++)
				interesados[i].avisarCambioPrecio (this, nuevo);
	}

	public void anotarInteresado (Cliente c) throws ArregloInteresadosLleno {
		if ( posicionInteresado (c) > -1)
			throw new InteresadoYaEstaException( );
		if (cantidadInteresados == maximoInteresados)
			throw new ArregloInteresadosLleno( );
		if (interesados == null)
			interesados = new Cliente [maximoInteresados];
		interesados [cantidadInteresados] = c;
		cantidadInteresados++;
	}

	public void eliminarInteresado (Cliente c) {
		int pos = posicionInteresado (c);
		if (pos > -1) {	// encontró el cliente
			// voy a eliminar el elemento del arreglo por compresión
			for (int i = pos; i < cantidadInteresados-1; i++) {
				interesados[i] = interesados[i+1];
			}
			interesados [cantidadInteresados - 1] = null;
			cantidadInteresados--;
		}
		else throw new InteresadoNoEstaException( );
	}

	private int posicionInteresado (Notificable c) {
		if (interesados == null)
			return -1;
		for (int pos = 0; pos < cantidadInteresados; pos++)
			if (interesados[pos] == c)
				return pos;
		return -1;
	}

	public boolean getReservado( ) {
		return reservado;
	}
			
	public void reservar( ) throws ReservaInvalidaException {
		if (reservado)
			throw new ReservaInvalidaException( );
		reservado = true;	
		if (interesados != null)
			for (int i = 0; i < cantidadInteresados; i++)
				interesados[i].avisarReserva(this);
	}

	public boolean getVendido( ) {
		return vendido;
	}
		
	public void vender( ) throws VentaInvalidaException {
		if (vendido)
			throw new VentaInvalidaException( );
		vendido = true;
		if (interesados != null)
			for (int i = 0; i < cantidadInteresados; i++)
				interesados[i].avisarVenta(this);
	}
		
	public void imprimirDatos( ) {
		System.out.println ("Domicilio: " + getDomicilio( ));
		System.out.println ("Superficie: " + getSuperficie( ));
		System.out.println ("Cantidad de ambientes: " + getCantidadAmbientes( ));
		System.out.println ("Precio: " + getPrecio( ));
		System.out.println ("Reservado: " + getReservado( ));
		System.out.println ("Vendido: " + getVendido( ));
		System.out.println ("Cantidad de interesados: " + cantidadInteresados);
		for (int i = 0; i < cantidadInteresados; i++)
			System.out.println (interesados[i].getNombre( ));
	}
	
	public abstract double comisionVendedor( );

}
