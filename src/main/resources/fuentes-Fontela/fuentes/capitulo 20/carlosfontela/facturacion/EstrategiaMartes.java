// EstrategiaMartes.java
package carlosfontela.facturacion;

public class EstrategiaMartes implements EstrategiaCalculo {

	public long calculoTotal(Factura f) {
		double monto = 0;
		for (int i = 0; i < f.getItems( ).length; i++) {
			if (f.getItems( )[i].getCodigo( ) < 100)
				monto += f.getItems( )[i].getMontoItem( )*0.9;
			else
				monto += f.getItems( )[i].getMontoItem( );
		}
		return (long)monto;
	}

}
