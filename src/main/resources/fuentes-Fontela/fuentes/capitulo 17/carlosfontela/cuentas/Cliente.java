package carlosfontela.cuentas;

public abstract class Cliente implements java.io.Serializable {
	
	private Domicilio direccion;
	private String email;
	private static final int maximoCuentas = 10;
	private CuentaBancaria[ ] cuentas;
	
	private int cantidadCuentas;

	public Cliente (String calle, int numero, String entre1, String entre2,
							String codigoPostal, String telefono, String email) {
		this.direccion = new Domicilio (calle, numero, entre1, entre2, codigoPostal, telefono);
		this.email = email;
		this.cuentas = new CuentaBancaria [maximoCuentas];
		this.cantidadCuentas = 0;
	}

	public Domicilio getDireccion ( ) {
			return direccion;
	}
	
	public void	setDireccion (Domicilio valor) {
			direccion = valor;
	}

	public String getEmail ( ) {
			return email;
	}
	
	public void setEmail (String valor) {
			email = valor;
	}
	
	public CuentaBancaria[ ] getCuentas ( ) {
			return cuentas;
	}

	public boolean agregarCuenta (CuentaBancaria cuenta) {
		if (cantidadCuentas < maximoCuentas) {
			cuentas [cantidadCuentas] = cuenta;
			cantidadCuentas++;
			return true;
		}
		else return false;
	}
	
	public int getCantidadCuentas ( ) {
			return cantidadCuentas;
	}
	
	public class Domicilio implements java.io.Serializable {
		private String calle;
		private int numero;
		private String entre1;
		private String entre2;
		private String codigoPostal;
		private String telefono;
		
		private Domicilio (String calle, int numero, String entre1, String entre2,
 							String codigoPostal, String telefono) {
			this.calle = calle;
			this.numero = numero;
			this.entre1 = entre1;
			this.entre2 = entre2;
			this.codigoPostal = codigoPostal;
			this.telefono = telefono;
		}

		public boolean equals (Object otroO) {
			if (!(otroO instanceof Domicilio))
				return false;
			Domicilio otro = (Domicilio)otroO;
			return (
					this.calle.equals(otro.calle) &&
					this.numero == otro.numero &&
					this.entre1.equals(otro.entre1) &&
					this.entre2.equals(otro.entre2) &&
					this.codigoPostal.equals(otro.codigoPostal) &&
					this.telefono.equals(otro.telefono)
			);
		}
		
		public String getTelefono( ) {
			return telefono;
		}

		public void setTelefono(String telefono) {
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
}
