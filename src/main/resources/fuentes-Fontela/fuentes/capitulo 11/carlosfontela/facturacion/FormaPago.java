package carlosfontela.facturacion;

public abstract class FormaPago {

	private String nombre;

	public FormaPago (String nombre) {
		this.nombre = nombre;
	}

	public String getNombre ( ) {
		return nombre;
	}
}
