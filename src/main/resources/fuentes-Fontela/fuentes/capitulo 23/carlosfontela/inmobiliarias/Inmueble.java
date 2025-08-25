// Inmueble.java
package carlosfontela.inmobiliarias;

import java.beans.*;

public abstract class Inmueble {

	private String domicilio;
	private double superficie;
	private int cantidadAmbientes;
	private int precio;
	private boolean reservado;
	private boolean vendido;

	private PropertyChangeSupport cambiosInmuebles = new PropertyChangeSupport(this);
	
	public Inmueble (String domicilio, double superficie, int cantidadAmbientes, int precio) {
		this.domicilio = domicilio;
		this.superficie = superficie;
		this.cantidadAmbientes = cantidadAmbientes;
		this.precio = precio;
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
		int precioAnterior = precio;
		precio = nuevo;
		cambiosInmuebles.firePropertyChange ("precio", precioAnterior, precio);
	}
		
	public boolean getReservado( ) {
		return reservado;
	}
			
	public void setReservado (boolean valor) {
		reservado = valor;	
		cambiosInmuebles.firePropertyChange ("reservado", false, true);
	}

	public void reservar( ) {
		setReservado(true);
	}
	
	public boolean getVendido( ) {
		return vendido;
	}
		
	public void setVendido (boolean valor) {
		// no se puede "des-vender" un inmueble
		if (valor == false)
			throw new IllegalArgumentException( );
		vendido = valor;
		cambiosInmuebles.firePropertyChange ("vendido", false, true);
	}
		
	public void vender ( ) {
		setVendido(true);
	}
	
	public void addPropertyChangeListener (PropertyChangeListener observador) {
		cambiosInmuebles.addPropertyChangeListener(observador);
	}
	
	public void removePropertyChangeListener (PropertyChangeListener observador) {
		cambiosInmuebles.removePropertyChangeListener(observador);
	}

	public void imprimirDatos( ) {
		System.out.println ("Domicilio: " + getDomicilio( ));
		System.out.println ("Superficie: " + getSuperficie( ));
		System.out.println ("Cantidad de ambientes: " + getCantidadAmbientes( ));
		System.out.println ("Precio: " + getPrecio( ));
		System.out.println ("Reservado: " + getReservado( ));
		System.out.println ("Vendido: " + getVendido( ));
		// suprimo la impresión de interesados
		// ya que ya no tengo acceso a los mismos
	}
	
	public abstract double comisionVendedor( );

}
