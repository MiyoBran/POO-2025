package carlosfontela.facturacion;

public class TarjetaDebito extends FormaPago {

	private String banco;
	
	public TarjetaDebito (String banco) {
		super ("TARJETA DE DÉBITO");
		this.banco = banco;
	}

}
