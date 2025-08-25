// Inmueble.java

package carlosfontela.inmobiliarias;

import java.util.*;

public abstract class Inmueble {

	private String domicilio;
	private double superficie;
	private int cantidadAmbientes;
	private int precio;
	private List<Cliente> interesados; 					// esta línea cambió
	private boolean reservado;
	private boolean vendido;
		
	public Inmueble (String domicilio, double superficie, int cantidadAmbientes, int precio) {
		this.domicilio = domicilio;
		this.superficie = superficie;
		this.cantidadAmbientes = cantidadAmbientes;
		this.precio = precio;
		this.interesados = new ArrayList<Cliente>( );		// esta línea cambió
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
		// cambió el ciclo y no necesito transformación de tipos explícita:
		for (Cliente c : interesados)
				c.avisarCambioPrecio(this,nuevo);
	}
		
	public void anotarInteresado (Cliente c) {
		interesados.add(c);
	}
		
	public void eliminarInteresado (Cliente c) {
		interesados.remove(c);
	}
		
	public boolean getReservado( ) {
		return reservado;
	}
			
	public void reservar( ) {
		reservado = true;	
		// cambió el ciclo y no necesito transformación de tipos explícita:
		for (Cliente c : interesados)
			c.avisarReserva(this);
	}
		
	public boolean getVendido( ) {
		return vendido;
	}
		
	public void vender( ) {
		vendido = true;
		// cambió el ciclo y no necesito transformación de tipos explícita:
		for (Cliente c : interesados)
			c.avisarVenta(this);
	}
		
	public void imprimirDatos( ) {
		System.out.println ("Domicilio: " + getDomicilio( ));
		System.out.println ("Superficie: " + getSuperficie( ));
		System.out.println ("Cantidad de ambientes: " + getCantidadAmbientes( ));
		System.out.println ("Precio: " + getPrecio( ));
		System.out.println ("Reservado: " + getReservado( ));
		System.out.println ("Vendido: " + getVendido( ));
		System.out.println ("Cantidad de interesados: " + interesados.size( ));
		// cambió el ciclo y no necesito transformación de tipos explícita:
		for (Cliente c : interesados)
			System.out.println (c.getNombre( ));
	}
	
	public abstract double comisionVendedor( );

}
