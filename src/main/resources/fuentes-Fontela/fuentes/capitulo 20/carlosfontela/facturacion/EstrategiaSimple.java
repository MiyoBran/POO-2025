// EstrategiaSimple.java
package carlosfontela.facturacion;

public class EstrategiaSimple implements EstrategiaCalculo {

	public long calculoTotal(Factura f) {
		long monto = 0;
		for (int i = 0; i < f.getItems( ).length; i++)
			monto += f.getItems( )[i].getMontoItem( );
		return monto;
	}
}
