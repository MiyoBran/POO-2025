// EstrategiaJubilados.java
package carlosfontela.facturacion;

public class EstrategiaJubilados implements EstrategiaCalculo {

	public long calculoTotal(Factura f) {
		double monto = 0;
		for (int i = 0; i < f.getItems( ).length; i++) {
			if (f.getItems( )[i].getPrecio( ) < 500)
				monto += f.getItems( )[i].getMontoItem( )*0.85;
			else
				monto += f.getItems( )[i].getMontoItem( );
		}
		return (long)monto;
	}
}

