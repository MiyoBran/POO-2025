// Notificable.java
package carlosfontela.inmobiliarias;

public interface Notificable {
	String getNombre( );
	void avisarCambioPrecio (Inmueble x, int nuevoPrecio);
	void avisarReserva (Inmueble x);
	void avisarVenta (Inmueble x);
}
