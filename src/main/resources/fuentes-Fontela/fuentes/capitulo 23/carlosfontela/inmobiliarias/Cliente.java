// Cliente.java
package carlosfontela.inmobiliarias;

import java.beans.*;

public class Cliente implements PropertyChangeListener, java.io.Serializable {

	private String nombre;
	private String telefono;
	private String email;
	
	public static final long serialVersionUID = 5;
	
	public Cliente (String nombre, String telefono, String email) {
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
	}
		
	public String getNombre( ) {
			return nombre;
	}
		
	public String getTelefono( ) {
			return telefono;
	}
		
	public String getEmail( ) {
			return email;
	}
		
	public void setTelefono (String nuevo) {
		telefono = nuevo;
	}
		
	public void setEmail (String nuevo) {
		email = nuevo;
	}

	public void anotarInteres (Inmueble x) {
		x.addPropertyChangeListener(this);
	}
	
	public void desinteresarse (Inmueble x) {
		x.removePropertyChangeListener(this);
	}

	public void propertyChange(PropertyChangeEvent evento) {
		Inmueble disparador = (Inmueble)evento.getSource( );
		if (evento.getPropertyName( ) == "precio")
			avisarCambioPrecio(disparador, disparador.getPrecio( ));
		else if (evento.getPropertyName( ) == "reservado")
			avisarReserva(disparador);
		else if (evento.getPropertyName( ) == "vendido")
			avisarVenta(disparador);
	}
	
	private void avisarCambioPrecio (Inmueble x, int nuevoPrecio) {
		String mensaje = "El inmueble " + x.getDomicilio( ) +
		" en el que estaba interesado ha cambiado de precio. Hoy cuesta $ " + nuevoPrecio;
		enviarMail (mensaje,"con nuevo precio");
	}
		
	private void avisarReserva (Inmueble x) {
		String mensaje = "El inmueble " + x.getDomicilio( ) +
			" en el que estaba interesado ha sido reservado.";
		enviarMail (mensaje,"reservado");
	}
		
	private void avisarVenta (Inmueble x) {
		String mensaje = "El inmueble " + x.getDomicilio( ) +
			" en el que estaba interesado ha sido vendido.";
		enviarMail (mensaje,"vendido");
	}
		
	private void enviarMail (String mensaje, String evento) {
		// TODO: enviar mail
		// este es un método sólo para probar; luego debe ser implementado
		System.out.println ("Mail a " + this.getNombre( ));
		System.out.println (evento);
		System.out.println (mensaje);
		System.out.println( );
	}
}
