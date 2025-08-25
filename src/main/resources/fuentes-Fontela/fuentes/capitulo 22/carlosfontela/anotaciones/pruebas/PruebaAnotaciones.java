package carlosfontela.anotaciones.pruebas;

public class PruebaAnotaciones {

	public static void main(String[] p) {
		
		BusquedaMetodosAutor busqueda =
			new BusquedaMetodosAutor (CuentaBancaria.class, "Carlos Fontela");
		int coincidencias = busqueda.ejecutar();
		System.out.println(coincidencias);		
	}

}
