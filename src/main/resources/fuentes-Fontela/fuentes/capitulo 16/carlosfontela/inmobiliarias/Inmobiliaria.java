// Inmobiliaria.java

package carlosfontela.inmobiliarias;

import java.util.*;

public class Inmobiliaria {
	private String nombre;
	private List<Inmueble> inmuebles;				// esta línea cambió
	private double comisionClienteCompra;
	private double comisionClienteVenta;
		
	public Inmobiliaria (String nombre, double comisionClienteCompra,
 							double comisionClienteVenta) {
		this.nombre = nombre;
		this.inmuebles = new ArrayList<Inmueble>( );	// esta línea cambió
		this.comisionClienteCompra = comisionClienteCompra;
		this.comisionClienteVenta = comisionClienteVenta;
}
		
	public String getNombre( ) {
			return nombre;
	}
		
	public int getCantidadInmuebles( ) {
		return inmuebles.size( );
	}
		
	public void agregarInmueble (Inmueble x) {
		inmuebles.add(x);
	}
		
	public void quitarInmueble (Inmueble x) {
		inmuebles.remove(x);
	}
		
	public void imprimirDatos ( ) {
		System.out.println("Inmobiliaria: " + this.getNombre( ));
		// cambió el ciclo y no necesito transformación de tipos explícita:
		for (Inmueble x : inmuebles)
			x.imprimirDatos( );
		System.out.println( );
	}

	public double getComisionClienteCompra( ) {
			return comisionClienteCompra;
	}
	
	public double getComisionClienteVenta( ) {
			return comisionClienteVenta;
	}

	public double beneficioEsperadoCartera( ) {
		double beneficio = 0;
		double comisionesCobradas =
 			(getComisionClienteCompra( ) + getComisionClienteVenta( )) / 100;
		// cambió el ciclo y no necesito transformación de tipos explícita:
		for (Inmueble x : inmuebles) {
			int precio = x.getPrecio( );
			if (!x.getVendido( ))
				beneficio += precio * comisionesCobradas - x.comisionVendedor( );
		}
		return beneficio;
	}

	public double beneficioEsperadoReservados( ) {
		double beneficio = 0;
		double comisionesCobradas =
 			(getComisionClienteCompra( ) + getComisionClienteVenta( )) / 100;
		// cambió el ciclo y no necesito transformación de tipos explícita:
		for (Inmueble x : inmuebles) {
			int precio = x.getPrecio( );
			if (!x.getVendido( ) && x.getReservado( ))
				beneficio += precio * comisionesCobradas - x.comisionVendedor( );
		}
		return beneficio;
	}

}
