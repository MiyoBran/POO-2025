package carlosfontela.anotaciones.pruebas;

import java.lang.annotation.*;
import java.lang.reflect.*;

import carlosfontela.anotaciones.PrologoMetodo;

public class BusquedaMetodosAutor {

	private Class claseBuscada;
	private String autorBuscado;
	private Method [ ] metodosClase; 
	
	public BusquedaMetodosAutor
			(Class clase, String autor) {
		this.claseBuscada = clase;
		this.autorBuscado = autor;
		this.metodosClase = clase.getMethods();
	}

	public int ejecutar ( ) {
		int cantidad = 0;
		for (Method metodo : metodosClase) {
			PrologoMetodo prologo = metodo.getAnnotation(PrologoMetodo.class);
			if (prologo != null) {
				String nombreAutorMetodo = prologo.autor();
				if (nombreAutorMetodo.equals(autorBuscado))
					cantidad++;
			}
		}
		return cantidad;
	}
}
