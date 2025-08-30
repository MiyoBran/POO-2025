// EstrategiaEmpleados.java
package carlosfontela.facturacion;

public class EstrategiaEmpleados implements EstrategiaCalculo {

	public long calculoTotal(Factura f) {
		long monto = 0;
		for (int i = 0; i < f.getItems( ).length; i++)
			monto += f.getItems( )[i].getMontoItem( );
		return (long)(monto*0.8);
	}
}
