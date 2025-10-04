// Inmobiliaria.java

package tp3.ej3.inmobiliarias;

public class Inmobiliaria implements Notificable {
	private String nombre;
	private int cantidadInmuebles;
	private final int maximoInmuebles = 100;
	private Inmueble[ ] inmuebles;
	private double comisionClienteCompra;
	private double comisionClienteVenta;

	public Inmobiliaria (String nombre, double comisionClienteCompra,
 							double comisionClienteVenta) {
		this.nombre = nombre;
		this.inmuebles = null;
		this.cantidadInmuebles = 0;
		this.comisionClienteCompra = comisionClienteCompra;
		this.comisionClienteVenta = comisionClienteVenta;
}

	// esta propiedad de Notificable ya estaba implementada:
	public String getNombre( ) {
			return nombre;
	}

	public int getCantidadInmuebles( ) {
		return cantidadInmuebles;
	}

	public void agregarInmueble (Inmueble x) {
		if (cantidadInmuebles == maximoInmuebles) {
			System.out.println ("Se super� el m�ximo de inmuebles para esta inmobiliaria");
			return;
		}
		if (inmuebles == null)
			inmuebles = new Inmueble [maximoInmuebles];
		inmuebles [cantidadInmuebles] = x;
		cantidadInmuebles++;
	}

	private int posicionInmueble (Inmueble x) {
		if (inmuebles == null)
			return -1;
		for (int pos = 0; pos < cantidadInmuebles; pos++)
			if (inmuebles[pos] == x)
				return pos;
		return -1;
	}

	public void quitarInmueble (Inmueble x) {
		int pos = posicionInmueble(x);
		if (pos > -1) {	// encontr� el inmueble
			// voy a eliminar el elemento del arreglo por compresi�n
			for (int i = pos; i < cantidadInmuebles-1; i++) {
				inmuebles[i] = inmuebles [i+1];
			}
			inmuebles [cantidadInmuebles-1] = null;
			cantidadInmuebles--;
		}
	}

	public void imprimirDatos ( ) {
		System.out.println ("Inmobiliaria: " + this.getNombre( ));
		if (inmuebles != null)
			for (int i = 0; i < cantidadInmuebles; i++)
				inmuebles[i].imprimirDatos( );
		System.out.println ( );
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
 			(getComisionClienteCompra( ) + getComisionClienteVenta( )) / 100.0;
		for (int i = 0; i < cantidadInmuebles; i++) {
			int precio = inmuebles[i].getPrecio( );
			if (!inmuebles[i].getVendido( )) {
				beneficio += precio * comisionesCobradas -
 					inmuebles[i].comisionVendedor( );
			}
			System.out.println (beneficio);
		}
		return beneficio;
	}

	public double beneficioEsperadoReservados( ) {
		double beneficio = 0;
		double comisionesCobradas =
 			(getComisionClienteCompra( ) + getComisionClienteVenta( )) / 100;
		for (int i = 0; i < cantidadInmuebles; i++) {
			int precio = inmuebles[i].getPrecio( );
			if (!inmuebles[i].getVendido( ) && inmuebles[i].getReservado( )) {
				beneficio += precio * comisionesCobradas -
 					inmuebles[i].comisionVendedor( );
			}
		}
		return beneficio;
	}

	// los 3 m�todos que siguen de Notificable debieron implementarse:
	public void avisarCambioPrecio (Inmueble x, int nuevoPrecio) {
		String mensaje = "El inmueble " + x.getDomicilio( ) +
 		" en el que estaba interesado ha cambiado de precio. Hoy cuesta $ " + nuevoPrecio;
		enviarMail (mensaje, "con nuevo precio");
	}

	public void avisarReserva (Inmueble x) {
		String mensaje = "El inmueble " + x.getDomicilio( ) +
 			" en el que estaba interesado ha sido reservado.";
		enviarMail (mensaje, "reservado");
	}

	public void avisarVenta (Inmueble x) {
		String mensaje = "El inmueble " + x.getDomicilio( ) +
 			" en el que estaba interesado ha sido vendido.";
		enviarMail (mensaje, "vendido");
	}

  @Override
  public void avisarRetiroventa(Inmueble x) {
    String mensaje = "El inmueble " + x.getDomicilio() +
        " en el que estaba interesado ha sido retirado de la venta.";
    enviarMail(mensaje, "retirado de la venta");

  }

  private void enviarMail (String mensaje, String evento) {
		// TODO: enviar mail
		// este es un m�todo s�lo para probar; luego debe ser implementado
		System.out.println ("Mail a " + this.getNombre( ));
		System.out.println (evento);
		System.out.println (mensaje);
		System.out.println( );
	}
}
