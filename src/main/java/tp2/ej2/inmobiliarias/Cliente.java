// Cliente.java
package tp2.ej2.inmobiliarias;

public class Cliente {

		private String nombre;
		private String telefono;
		private String email;

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

		private void enviarMail (String mensaje, String evento) {
			// TODO: enviar mail
			// este es un m�todo s�lo para probar; luego debe ser implementado
			System.out.println ("Mail a " + this.getNombre( ));
			System.out.println (evento);
			System.out.println (mensaje);
			System.out.println( );
		}
}
