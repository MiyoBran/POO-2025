// Inmobiliaria.java
package carlosfontela.inmobiliarias;

public class Inmobiliaria {
	private String nombre;
	private int cantidadInmuebles;
	private final int maximoInmuebles = 100;
	private Inmueble[ ] inmuebles;
	private double comisionClienteCompra;
	private double comisionClienteVenta;
		
	public Inmobiliaria (String nombre,
 			double comisionClienteCompra, double comisionClienteVenta) {
		this.nombre = nombre;
		this.inmuebles = null;
		this.cantidadInmuebles = 0;
		this.comisionClienteCompra = comisionClienteCompra;
		this.comisionClienteVenta = comisionClienteVenta;
}
		
	public String getNombre( ) {
		return nombre;
	}
		
	public int getCantidadInmuebles( ) {
		return cantidadInmuebles;
	}
		
	public void agregarInmueble (Inmueble x) {
		if (cantidadInmuebles == maximoInmuebles) {
			System.out.println ("Se superó el máximo de inmuebles para esta inmobiliaria");
			return;
		}
		if (inmuebles == null)
			inmuebles = new Inmueble [maximoInmuebles];
		inmuebles [cantidadInmuebles] = x;
		cantidadInmuebles++;
	}

	private int buscar (Inmueble[] inmuebles, Inmueble x) {
		if (inmuebles == null)
			return -1;
		for (int pos = 0; pos < cantidadInmuebles; pos++)
			if (inmuebles[pos] == x)
				return pos;
		return -1;
	}
	
	public void quitarInmueble (Inmueble x) {
		if (inmuebles == null)
			return;
		int pos = buscar (inmuebles, x); 	// busca el inmueble en el arreglo
		if (pos > -1)	 // encontró el inmueble
		{	inmuebles [pos] = InmuebleNull.getInstancia( );
			cantidadInmuebles--;
		}
	}

	private static void ordenar (Inmueble[ ] inmueblesOrdenado, CommandComparador orden) {
		for (int i = 0; i < inmueblesOrdenado.length-1; i++)
			for (int j = i+1; j < inmueblesOrdenado.length; j++)
			if (orden.comparador(inmueblesOrdenado[i],inmueblesOrdenado[j])) {
				Inmueble temp = inmueblesOrdenado[i];
				inmueblesOrdenado[i] = inmueblesOrdenado[j];
				inmueblesOrdenado[j] = temp;
			}
	}

	public void imprimirDatos (CommandComparador orden) {
		Inmueble[ ] inmueblesOrdenado = new Inmueble[inmuebles.length];
		// pasamos los inmuebles a otro arreglo para preservar la colección original:
		int k = 0;
		for (Object o : inmuebles){
			inmueblesOrdenado[k] = (Inmueble)o;
			k++;
		}
		ordenar (inmueblesOrdenado, orden);
		System.out.println ("Inmobiliaria: " + this.getNombre( ));
		for (Inmueble x : inmueblesOrdenado)
			x.imprimirDatos( );
		System.out.println( );
	}


	public double beneficioEsperadoCartera( ) {
		double beneficio = 0;
		double comisionesCobradas = ( getComisionClienteCompra( ) +
								getComisionClienteVenta( ) ) / 100;
		for (int i = 0; i < cantidadInmuebles; i++)
				if ( ! inmuebles[i].getVendido( ) )
					beneficio += inmuebles[i].beneficioParcial(comisionesCobradas);
		return beneficio;
	}

	public double beneficioEsperadoReservados( ) {
		double beneficio = 0;
		double comisionesCobradas = ( getComisionClienteCompra( ) +
 								getComisionClienteVenta ( ) ) / 100;
		for (int i = 0; i < cantidadInmuebles; i++)
				if ( ! inmuebles[i].getVendido( ) && inmuebles[i].getReservado( ) )
					beneficio += inmuebles[i].beneficioParcial(comisionesCobradas);
		return beneficio;
	}

	public double getComisionClienteCompra( ) {
		return comisionClienteCompra;
	}
	
	public double getComisionClienteVenta( ) {
		return comisionClienteVenta;
	}

}
