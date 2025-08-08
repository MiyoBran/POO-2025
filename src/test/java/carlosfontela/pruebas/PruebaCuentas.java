// PruebaCuentas.java
package carlosfontela.pruebas;

import carlosfontela.cuentas.*;

public class PruebaCuentas {

	private static CajaAhorro cajaAhorro;
	private static CuentaCorriente cuentaCorriente;

	private static void chequearIgualdad (boolean valorEsperado, boolean valorObtenido) {
		if (valorEsperado == valorObtenido)
			System.out.println("OK");
		else {
			System.out.print("ERROR: Se esperaba el valor ");
			System.out.print(valorEsperado);
			System.out.print(" y se obtuvo ");
			System.out.print(valorObtenido);
		}
	}

	private static void chequearIgualdad (double valorEsperado, double valorObtenido,
											double tolerancia) {
		boolean ok = Math.abs (valorEsperado - valorObtenido) < tolerancia;
		if (ok)
			System.out.println("OK");
		else {
			System.out.print("ERROR: Se esperaba el valor ");
			System.out.print(valorEsperado);
			System.out.print(" y se obtuvo ");
			System.out.print(valorObtenido);
		}
	}
	
	private static void reiniciar( ) {
		cajaAhorro = new CajaAhorro (1234, "Juan Pérez");
		cuentaCorriente = new CuentaCorriente (5678, "Ana García", 1000);
	}

	private static void testDeposito( ) {
		reiniciar( );
		cajaAhorro.depositar(500);
		cuentaCorriente.depositar(500);
		chequearIgualdad (500, cajaAhorro.getSaldo( ), 1E-4);
		chequearIgualdad (500, cuentaCorriente.getSaldo( ), 1E-4);
	}
	
	private static void testExtraccionSinSaldo( ) {
		reiniciar( );
		boolean okCA = cajaAhorro.extraer(1000);
		boolean okCC = cuentaCorriente.extraer(1000);
		chequearIgualdad (false, okCA);
		chequearIgualdad (true, okCC);
		chequearIgualdad (0, cajaAhorro.getSaldo( ), 1E-4);
		chequearIgualdad (-1000, cuentaCorriente.getSaldo( ), 1E-4);
	}
	
	private static void testExtraccionConSaldo( ) {
		reiniciar( );
		cajaAhorro.depositar(500);
		cuentaCorriente.depositar(500);
		boolean okCA = cajaAhorro.extraer(100);
		boolean okCC = cuentaCorriente.extraer(100);
		chequearIgualdad (true, okCA);
		chequearIgualdad (true, okCC);
		chequearIgualdad (400, cajaAhorro.getSaldo( ), 1E-4);
		chequearIgualdad (400, cuentaCorriente.getSaldo( ), 1E-4);
	}

	private static void testCambios( ) {
		reiniciar( );
		cajaAhorro.setInteresesGanados (150);
		cajaAhorro.pagarIntereses( );
		cuentaCorriente.setDescubierto(100);
		chequearIgualdad (150, cajaAhorro.getSaldo( ), 1E-4);
		chequearIgualdad (100, cuentaCorriente.getDescubierto( ), 1E-4);
	}

	public static void main(String[ ] args) {
		testDeposito( );
		testExtraccionSinSaldo( );
		testExtraccionConSaldo( );
		testCambios( );
	}
}
