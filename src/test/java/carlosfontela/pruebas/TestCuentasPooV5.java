package carlosfontela.pruebas;

import static org.junit.Assert.assertEquals;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;


import poo.cuentas.CajaAhorro;
import poo.cuentas.CuentaCorriente;
import poo.cuentas.SaldoInsuficienteException;

class TestCuentasPooV5 {

	private static CajaAhorro cajaAhorro;
	private static CuentaCorriente cuentaCorriente;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void inicializarObjetos() throws Exception {
		cajaAhorro = new CajaAhorro(1234, "Juan Pérez");
		cuentaCorriente = new CuentaCorriente(5678, "Ana García", 1000);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void deposito() {
		cajaAhorro.depositar(500);
		cuentaCorriente.depositar(500);
		assertEquals(500, cajaAhorro.getSaldo(), 1E-4);
		assertEquals(500, cuentaCorriente.getSaldo(), 1E-4);
	}

	/*
	 * V4
	 * @Test(expected = SaldoInsuficienteException.class)
	public void extraccionSinSaldo() throws SaldoInsuficienteException {
		cajaAhorro.extraer(1000);
		cuentaCorriente.extraer(1000);
		assertEquals(0, cajaAhorro.getSaldo(), 1E-4);
		assertEquals(-1000, cuentaCorriente.getSaldo(), 1E-4);
	}*/
	
	@Test
	void testCajaAhorroThrowsException() throws Exception {
	    Assertions.assertThrows(SaldoInsuficienteException.class, () -> {
	    	//cajaAhorro.depositar(1000);
	    	cajaAhorro.extraer(1000);
	    });
	}
	
	@Test
	void testCuentaCorrienteThrowsException() throws Exception {
		Exception exception = Assertions.assertThrows(SaldoInsuficienteException.class, () -> {
			cuentaCorriente.extraer(1000); 	    
			});
	    String expectedMessage = "Saldo Insuficiente en Cuenta Corriente";
	    String actualMessage = exception.getMessage();

	    assertTrue(actualMessage.contains(expectedMessage));

	}
	
	
	@Test
	void extraccionConSaldo() throws SaldoInsuficienteException {
		cajaAhorro.depositar(500);
		cuentaCorriente.depositar(500);
		cajaAhorro.extraer(200);
		cuentaCorriente.extraer(100);
		assertEquals(300, cajaAhorro.getSaldo(), 1E-4);
		assertEquals(400, cuentaCorriente.getSaldo(), 1E-4);
	}

	@Test
	void cambios() {
		cajaAhorro.setInteresesGanados(150);
		cajaAhorro.pagarIntereses();
		//cuentaCorriente.setDescubierto(100);
		assertEquals(150, cajaAhorro.getSaldo(), 1E-4);
		assertEquals(1000, cuentaCorriente.getDescubierto(), 1E-4);
	}

}
