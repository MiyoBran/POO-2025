// Cliente.java

package carlosfontela.pruebas;

public class Cliente {

		private class Domicilio {
			String calle;
			int numero;
			String entre1;
			String entre2;
			String codigoPostal;
			String telefono;

			private Domicilio (String calle, int numero, String entre1, String entre2,
 				String codigoPostal, String telefono) {
				this.calle = calle;
				this.numero = numero;
				this.entre1 = entre1;
				this.entre2 = entre2;
				this.codigoPostal = codigoPostal;
				this.telefono = telefono;
			}

			public String getTelefono( ) {
				return telefono;
			}

			public void setTelefono (String telefono) {
				this.telefono = telefono;
			}

			public String getCalle( ) {
				return calle;
			}

			public String getCodigoPostal( ) {
				return codigoPostal;
			}

			public String getEntre1( ) {
				return entre1;
			}

			public String getEntre2( ) {
				return entre2;
			}

			public int getNumero( ) {
				return numero;
			}

		}

		private String nombre;
		private String apellido;
		private Domicilio domicilio;
		private String email;

		public Cliente (String nombre, String apellido, String calle, int numero,
 				String entre1, String entre2, String codigoPostal, String telefono, String email) {
			this.nombre = nombre;
			this.apellido = apellido;
			this.domicilio = new Domicilio (calle, numero, entre1, entre2, codigoPostal, telefono);
			this.email = email;
		}

		public Domicilio getDomicilio( ) {
			return domicilio;
		}
		public void setDomicilio (Domicilio domicilio) {
			this.domicilio = domicilio;
		}
		public String getEmail( ) {
			return email;
		}
		public void setEmail (String email) {
			this.email = email;
		}
		public String getApellido( ) {
			return apellido;
		}
		public String getNombre( ) {
			return nombre;
		}
}
