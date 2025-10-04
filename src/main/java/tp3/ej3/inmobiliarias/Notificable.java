// Notificable.java
package tp3.ej3.inmobiliarias;

public interface Notificable {
	String getNombre( );
	void avisarCambioPrecio (Inmueble x, int nuevoPrecio);
	void avisarReserva (Inmueble x);
	void avisarVenta (Inmueble x);
  void avisarRetiroventa (Inmueble x);
}
