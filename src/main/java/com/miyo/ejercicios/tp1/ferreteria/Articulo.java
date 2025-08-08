package com.miyo.ejercicios.tp1.ferreteria;


/**
 * Clase que representa un artículo en el negocio.
 */
public class Articulo {
	// Atributos
	private int codigo;
	private String descripcion;
	private double precio;
	private int cantidad;
	
	// Constructor
	public Articulo(int codigo, String descripcion, double precio, int cantidad) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precio = precio;
		this.cantidad = cantidad;
	}
	
	// Getters y Setters
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	

	

}
