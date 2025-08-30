// Inmobiliaria.java

package carlosfontela.inmobiliarias;

import java.util.*;

public class Inmobiliaria {
	private String nombre;
	private List inmuebles;					// uso de List
	private double comisionClienteCompra;
	private double comisionClienteVenta;
		
	public Inmobiliaria (String nombre, double comisionClienteCompra,
 							double comisionClienteVenta) {
		this.nombre = nombre;
		this.inmuebles = new ArrayList( );		// uso de ArrayList
		this.comisionClienteCompra = comisionClienteCompra;
		this.comisionClienteVenta = comisionClienteVenta;
}
		
	public String getNombre( ) {
		return nombre;
	}
		
	public int getCantidadInmuebles( ) {
		return inmuebles.size( );			// gané en simplicidad y claridad
	}
		
	public void agregarInmueble (Inmueble x) {
		inmuebles.add(x); 				// gané en simplicidad y claridad
	}
		
	public void quitarInmueble (Inmueble x) {
		inmuebles.remove(x);			// gané en simplicidad y claridad
	}
		
	public void imprimirDatos ( ) {
		System.out.println ("Inmobiliaria: " + this.getNombre( ));
		for (Object x : inmuebles) 		// gané en simplicidad y claridad
			((Inmueble)x).imprimirDatos( );
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
		for (Object o : inmuebles) {		// gané en simplicidad y claridad
			Inmueble x = (Inmueble)o;
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
		for (Object o : inmuebles) {		// gané en simplicidad y claridad
			Inmueble x = (Inmueble)o;
			int precio = x.getPrecio( );
			if (!x.getVendido( ) && x.getReservado( ))
				beneficio += precio * comisionesCobradas - x.comisionVendedor( );
		}
		return beneficio;
	}
}
