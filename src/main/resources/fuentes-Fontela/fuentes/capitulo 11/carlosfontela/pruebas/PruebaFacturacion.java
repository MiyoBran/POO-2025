package carlosfontela.pruebas;

import carlosfontela.facturacion.*;

public class PruebaFacturacion {

	public static void main (String [ ] p) {

		FormaPago efectivo = new Efectivo( );
		FormaPago visa = new TarjetaCredito ("VISA");
		FormaPago naranja = new TarjetaCredito ("NARANJA");
		FormaPago galicia = new TarjetaDebito ("Galicia");
		
		ItemFactura[ ] items1 = new ItemFactura [3];
		items1[0] = new ItemFactura (22, "Arroz", 122, 1);
		items1[1] = new ItemFactura (33 ,"Dulce de leche" ,355, 2);
		items1[2] = new ItemFactura (44, "Chorizo", 99, 1);
		PagoParcial[ ] pagos1 = new PagoParcial [1];
		pagos1[0] = new PagoParcial (visa, 931);
		Factura f1 = new Factura (items1, pagos1);
		System.out.print ("Monto factura - debería dar: ");
		System.out.println (122 + 355 * 2+ 99);
		System.out.println ( f1.monto() );
		System.out.println ("Balanceada (true): " + f1.balanceada( ));
		
		ItemFactura[ ] items2 = new ItemFactura [3];
		items2[0] = new ItemFactura (55, "Merluza", 1140, 2);
		items2[1] = new ItemFactura (55, "Merluza", 1140, 1);
		items2[2] = new ItemFactura (66, "Lechuga", 35, 1);
		PagoParcial[ ] pagos2 = new PagoParcial [2];
		pagos2[0] = new PagoParcial (efectivo, 931);
		pagos2[1] = new PagoParcial (naranja, 931);
		Factura f2 = new Factura (items2, pagos2);
		System.out.print ("Monto factura - debería dar: ");
		System.out.println (1140 * 3 + 35);
		System.out.println ( f2.monto() );
		System.out.println ("Balanceada (false): " + f2.balanceada( ));
		
		ItemFactura[ ] items3 = new ItemFactura [2];
		items3[0] = new ItemFactura (55, "Merluza", 1140, 3);
		items3[1] = new ItemFactura (33, "Dulce de leche", 355, 2);
		PagoParcial[ ] pagos3 = new PagoParcial [2];
		pagos3[0] = new PagoParcial (efectivo, 2000);
		pagos3[1] = new PagoParcial (naranja, 2130);
		Factura f3 = new Factura (items3, pagos3);
		System.out.print ("Monto factura - debería dar: ");
		System.out.println (1140 * 3 + 355 * 2);
		System.out.println ( f3.monto() );
		System.out.println ("Balanceada (true): " + f3.balanceada( ));

	}

}
