package carlosfontela.pruebas;

import java.util.Date;
import junit.framework.TestCase;
import carlosfontela.facturacion.*;

public class PruebaFacturacion extends TestCase {

	private ItemFactura[ ] items = new ItemFactura[5];
	private PagoParcial[ ] pagos = new PagoParcial[1];
	
	protected void setUp( ) throws Exception {
		items[0] = new ItemFactura (22, "Arroz", 122, 1);
		items[1] = new ItemFactura (33, "Dulce de leche", 355, 2);
		items[2] = new ItemFactura (111, "Chorizo", 99, 1);
		items[3] = new ItemFactura (66, "Lechuga", 35, 1);
		items[4] = new ItemFactura (333, "Plato sopero", 612, 3);
		
		// no interesa el monto porque no es lo que se verifica:
		pagos[0] = new PagoParcial (new Efectivo(), 1000);
	}

	public void testSimple( ) {
		Factura fs = new Factura (items, pagos, false, false);
		assertEquals ((long)(122+ 355*2 + 99 + 35 + 612*3), fs.montoFactura( ));
	}

	public void testJubilado( ) {
		Factura fj = new Factura (items, pagos, true, false);
		assertEquals ((long) ((122+355*2+99+35)*0.85+612*3), fj.montoFactura( ));
	}

	public void testEmpleado( ) {
		Factura fe = new Factura (items, pagos, false, true);
		assertEquals ((long) ((122+355*2+99+35+612*3)*0.8), fe.montoFactura( ));
	}

	private static boolean hoyEsMartes ( ) {
		Date hoy = new Date( );
		return (hoy.getDay( ) == 2);
	}
	
	// esta prueba va a fallar si se corre un día que no sea martes
	public void testMartes( ) {
		Factura fm = new Factura (items, pagos, false, false);
		if (hoyEsMartes( ))
			assertEquals ((long) ((122+355*2+35) * 0.9 + 99 + 612*3), fm.montoFactura( ));
		else
			assertEquals (122+355*2+99+35+612*3, fm.montoFactura( ));
	}

	// esta prueba tiene sentido si se la corre un martes
	public void testMartesJubilado( ) {
		Factura fmj = new Factura (items, pagos, true, false);
		assertEquals ((long) ((122+355*2+99+35) * 0.85 + 612*3), fmj.montoFactura( ));
	}

	public void testJubiladoEmpleado( ) {
		Factura fje = new Factura (items, pagos, true, true);
		assertEquals ((long) ((122+355*2+99+35+612*3) * 0.8), fje.montoFactura( ));
	}
}
