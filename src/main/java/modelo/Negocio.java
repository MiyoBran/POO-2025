package modelo;

import java.time.LocalDate;

public class Negocio {
	private String cuit;
	private String nombre;
	
	public Negocio(String cuit, String nombre) {
		// TODO Auto-generated constructor stub
		this.cuit = cuit;
		this.nombre = nombre;
	}

	public Articulo agregarArticulo(int codigo, String descripcion, double precio, int cantidad) {
		// TODO Auto-generated method stub
		Articulo articulo = new Articulo(codigo, descripcion, precio, cantidad);
		return null;
	}

	public Factura agregarFactura(int idFactura, LocalDate fecha, Articulo item, int cantidad) {
		// TODO Auto-generated method stub
		Factura factura = new Factura(idFactura, fecha, item, cantidad);
		return null;
	}

}
