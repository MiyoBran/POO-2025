// Inmueble.java
package carlosfontela.inmobiliarias;

public abstract class Inmueble {

	private String domicilio;
	private double superficie;
	private int cantidadAmbientes;
	private int precio;
	private Cliente[ ] interesados;
	private int cantidadInteresados;
	private final int maximoInteresados = 1000;
	private boolean reservado;
	private boolean vendido;
		
	public Inmueble (String domicilio, double superficie, int cantidadAmbientes, int precio) {
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
	
	public void setPrecio(int nuevo) {
		precio = nuevo;
		if (interesados != null)
			for (int i = 0; i < cantidadInteresados; i++)
				interesados[i].avisarCambioPrecio(this,nuevo);
	}
		
	public void anotarInteresado (Cliente c) {
		if (cantidadInteresados == maximoInteresados) {
			System.out.println ("Se superó el máximo de interesados para este inmueble");
			return;
		}
		if (interesados == null)
			interesados = new Cliente [maximoInteresados];
		interesados [cantidadInteresados] = c;
		cantidadInteresados++;
	}

	private int posicionInteresado (Cliente c) {
		if (interesados == null)
			return -1;
		for (int pos = 0; pos < cantidadInteresados; pos++)
			if (interesados[pos] == c)
				return pos;
		return -1;
	}

	public void eliminarInteresado (Cliente c) {
		int pos = posicionInteresado(c);
		if (pos > -1) {	// encontró el cliente
			// voy a eliminar el elemento del arreglo por compresión
			for (int i = pos; i < cantidadInteresados-1; i++) {
				interesados[i] = interesados[i+1];
			}
			interesados [cantidadInteresados - 1] = null;
			cantidadInteresados--;
		}
	}

	public boolean getReservado( ) {
		return reservado;
	}
			
	public void reservar( ) {
		reservado = true;	
		if (interesados != null)
			for (int i = 0; i < cantidadInteresados; i++)
				interesados[i].avisarReserva(this);
	}
		
	public boolean getVendido( ) {
		return vendido;
	}
		
	public void vender( ) {
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

	public double beneficioParcial (double comisionesCobradas) {
		double beneficio = 0;
		int precio = this.getPrecio( );
		beneficio += precio * comisionesCobradas
						- this.comisionVendedor( );
		return beneficio;
	}
	

}
