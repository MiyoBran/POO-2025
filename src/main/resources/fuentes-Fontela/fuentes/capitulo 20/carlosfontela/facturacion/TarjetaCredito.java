package carlosfontela.facturacion;

public class TarjetaCredito extends FormaPago {

	private String marca;
	
	public TarjetaCredito (String marca) {
		super ("TARJETA DE CREDITO");
		this.marca = marca;
	}
}
