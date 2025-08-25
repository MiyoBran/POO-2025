// Factura.java
package carlosfontela.facturacion;

import java.util.*;

public class Factura {
	private Date fecha;
	private ItemFactura[ ] items;
	private PagoParcial[ ] pagos;
	private EstrategiaCalculo estrategia;
		
	private static boolean esMartes (Date fecha) {
		return (fecha.getDay( ) == 2);
	}
		
	public Factura (ItemFactura[ ] items, PagoParcial[ ] pagos,
 					boolean jubilado, boolean empleado) {
		this.fecha = new Date( );
		this.items = items;
		this.pagos = pagos;
		if (empleado)
			this.estrategia = new EstrategiaEmpleados( );
		else if (jubilado)
			this.estrategia = new EstrategiaJubilados( );
		else if (esMartes(fecha))
			this.estrategia = new EstrategiaMartes( );
		else this.estrategia = new EstrategiaSimple( );
	}
		
	public Date getFecha( ) {
		return fecha;
	}
		
	public ItemFactura[ ] getItems( ) {
		return items;
	}
		
	public PagoParcial[ ] getPagos( ) {
		return pagos;
	}
		
	public long montoFactura( ) {
		return estrategia.calculoTotal(this);
	}
		
	private long pagosTotal( ) {
		long total = 0;
		for (int i = 0; i < pagos.length; i++)
			total += pagos[i].getMonto( );
		return total;
	}
		
	public boolean balanceada( ) {
		return (montoFactura( ) == pagosTotal( ));
	}
}
