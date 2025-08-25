package carlosfontela.facturacion;

import java.util.Date;

public class Factura {

	private Date fecha;
	private ItemFactura[ ] items;
	private PagoParcial[ ] pagos;
	
	public Factura (ItemFactura[ ] items, PagoParcial[ ] pagos) {
		this.fecha = new Date ( );
		this.items = items;
		this.pagos = pagos;
	}
	
	public Date getFecha ( ) {
		return fecha;
	}
	
	public ItemFactura[ ] getItems ( ) {
		return items;
	}
	
	public PagoParcial[ ] getPagos ( ) {
		return pagos;
	}
	
	public long monto ( ) {
			long monto = 0;
			for (int i = 0; i < items.length; i++)
				monto += items[i].getMontoItem();
			return monto;
	}
	
	private long totalPagos ( ) {
			long total = 0;
			for (int i = 0; i < pagos.length; i++)
				total += pagos[i].getMonto();
			return total;
	}
	
	public boolean balanceada ( ) {
		return ( monto ( ) == totalPagos ( ) );
	}

}

