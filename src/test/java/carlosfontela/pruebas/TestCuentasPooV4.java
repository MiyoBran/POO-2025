package carlosfontela.pruebas;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


import poo.cuentas.CajaAhorro;
import poo.cuentas.CuentaCorriente;
import poo.cuentas.SaldoInsuficienteException;

public class TestCuentasPooV4 {

	private static CajaAhorro cajaAhorro;
	private static CuentaCorriente cuentaCorriente;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		cajaAhorro = new CajaAhorro(1234, "Juan Pérez");
		cuentaCorriente = new CuentaCorriente(5678, "Ana García", 1000);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void deposito() {
		cajaAhorro.depositar(500);
		cuentaCorriente.depositar(500);
		assertEquals(500, cajaAhorro.getSaldo(), 1E-4);
		assertEquals(500, cuentaCorriente.getSaldo(), 1E-4);
	}

	@Test(expected = SaldoInsuficienteException.class)
	public void extraccionSinSaldo() throws SaldoInsuficienteException {
		cajaAhorro.extraer(1000);
		cuentaCorriente.extraer(1000);
		assertEquals(0, cajaAhorro.getSaldo(), 1E-4);
		assertEquals(-1000, cuentaCorriente.getSaldo(), 1E-4);
	}
	
	@Test
	public void extraccionConSaldo() throws SaldoInsuficienteException {
		cajaAhorro.depositar(500);
		cuentaCorriente.depositar(500);
		cajaAhorro.extraer(100);
		cuentaCorriente.extraer(100);
		assertEquals(400, cajaAhorro.getSaldo(), 1E-4);
		assertEquals(400, cuentaCorriente.getSaldo(), 1E-4);
	}

	@Test
	public void cambios() {
		cajaAhorro.setInteresesGanados(150);
		cajaAhorro.pagarIntereses();
		cuentaCorriente.setDescubierto(100);
		assertEquals(150, cajaAhorro.getSaldo(), 1E-4);
		assertEquals(100, cuentaCorriente.getDescubierto(), 1E-4);
	}

}
