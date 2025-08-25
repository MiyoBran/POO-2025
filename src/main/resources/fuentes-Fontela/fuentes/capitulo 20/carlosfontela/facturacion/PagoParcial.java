package carlosfontela.facturacion;

public class PagoParcial {

	private FormaPago forma;
	private long monto;
	
	public PagoParcial (FormaPago forma, long monto) {
		this.forma = forma;
		this.monto = monto;
	}
	
	public FormaPago getFormaPago ( ) {
		return forma;
	}
	
	public long getMonto ( ) {
		return monto;
	}
}
