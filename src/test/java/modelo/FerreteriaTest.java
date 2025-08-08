package modelo;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FerreteriaTest {

	private Negocio ferreteria;
	private Articulo des, mar, pin;
	private Factura factura1, factura2, factura3, factura4;

	@BeforeEach
	void setUp() {
		ferreteria = new Negocio("30-37148498-8", "Ferreteria");
		des = ferreteria.agregarArticulo(10010, "destornillador", 150.20, 30);
		mar = ferreteria.agregarArticulo(10020, "martillo", 250.00, 20);
		pin = ferreteria.agregarArticulo(10030, "pinza", 350.00, 5);

		factura1 = ferreteria.agregarFactura(100, LocalDate.of(2022, 8, 1), des, 4);
		factura1.agregarItem(mar, 1);
		factura1.agregarItem(pin, 2);

		factura2 = ferreteria.agregarFactura(101, LocalDate.of(2022, 8, 2), des, 10);
		factura2.agregarItem(mar, 2);

		factura3 = ferreteria.agregarFactura(102, LocalDate.of(2022, 8, 3), des, 5);

		factura4 = ferreteria.agregarFactura(103, LocalDate.of(2022, 8, 4), mar, 2);
	}

	@Test
	void testImporteFactura() {
		assertEquals(1550.80, factura1.importeTotal(), 0.01);
		assertEquals(2002.00, factura2.importeTotal(), 0.01);
		assertEquals(751.00, factura3.importeTotal(), 0.01);
		assertEquals(500.00, factura4.importeTotal(), 0.01);
	}

	@Test
	void testCambioPrecio() {
		mar.setPrecio(275.00);
		assertEquals(500.00, factura4.importeTotal(), 0.01);
	}

	@Test
	void testArticuloIngresado() {
		assertThrows(ArticuloRepetidoException.class, () -> {
			factura4.agregarItem(mar, 2);
		});
	}

	@Test
	void testStockInsuficiente() {
		assertThrows(StockInsuficienteException.class, () -> {
			factura4.agregarItem(pin, 5);
		});
	}
}