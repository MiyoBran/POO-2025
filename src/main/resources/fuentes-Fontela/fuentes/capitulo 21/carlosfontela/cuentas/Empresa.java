package carlosfontela.cuentas;

public class Empresa extends Cliente implements Cloneable, java.io.Serializable {
	
	private String razonSocial;
	private String cuit;
	
	
	public Empresa (String razonSocial, String cuit, String calle, int numero,
			String entre1, String entre2, String codigoPostal, String telefono, String email) {
		super (calle, numero, entre1, entre2, codigoPostal, telefono, email);
		this.razonSocial = razonSocial;
		this.cuit = cuit;
	}
	
	public String getRazonSocial ( ) {
			return razonSocial;
	}

	public String getCuit ( ) {
			return cuit;
	}

	public Object clone( ) {
		Object copia = null;
		try {
			copia = (Empresa)super.clone( );
		} catch (CloneNotSupportedException e) {}
		return copia;
	}
}
