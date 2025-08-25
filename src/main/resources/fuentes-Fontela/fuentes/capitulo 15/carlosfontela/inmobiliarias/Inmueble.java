// Inmueble.java

package carlosfontela.inmobiliarias;

import java.util.*;

public abstract class Inmueble {

	private String domicilio;
	private double superficie;
	private int cantidadAmbientes;
	private int precio;
	private List interesados;						// uso de List
	private boolean reservado;
	private boolean vendido;
		
	public Inmueble (String domicilio, double superficie, int cantidadAmbientes, int precio) {
		this.domicilio = domicilio;
		this.superficie = superficie;
		this.cantidadAmbientes = cantidadAmbientes;
		this.precio = precio;
		this.interesados = new ArrayList( );			// uso de ArrayList
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
		for (Object c : interesados)			// gané en simplicidad y claridad
				((Cliente)c).avisarCambioPrecio(this,nuevo);
	}
		
	public void anotarInteresado (Cliente c) {
		interesados.add(c);				// gané en simplicidad y claridad
	}
		
	public void eliminarInteresado (Cliente c) {
		interesados.remove(c);				// gané en simplicidad y claridad
	}
		
	public boolean getReservado( ) {
		return reservado;
	}
			
	public void reservar( ) {
		reservado = true;	
		for (Object c : interesados)			// gané en simplicidad y claridad
			((Cliente)c).avisarReserva(this);
	}
		
	public boolean getVendido( ) {
		return vendido;
	}
		
	public void vender( ) {
		vendido = true;
		for (Object c : interesados)			// gané en simplicidad y claridad
			((Cliente)c).avisarVenta(this);
	}
		
	public void imprimirDatos( ) {
		System.out.println ("Domicilio: " + getDomicilio( ));
		System.out.println ("Superficie: " + getSuperficie( ));
		System.out.println ("Cantidad de ambientes: " + getCantidadAmbientes( ));
		System.out.println ("Precio: " + getPrecio( ));
		System.out.println ("Reservado: " + getReservado( ));
		System.out.println ("Vendido: " + getVendido( ));
		System.out.println ("Cantidad de interesados: " + interesados.size( ));
		for (Object c : interesados)			// gané en simplicidad y claridad
			System.out.println (((Cliente)c).getNombre( ));
	}
	
	public abstract double comisionVendedor( );

}
