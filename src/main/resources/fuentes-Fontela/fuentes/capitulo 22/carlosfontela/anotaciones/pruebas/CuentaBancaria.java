package carlosfontela.anotaciones.pruebas;

import carlosfontela.anotaciones.*;

public class CuentaBancaria {

	private int numero;
	private String titular;
	private double saldo;

	public CuentaBancaria (int numero, String titular) {
			this.numero = numero;
			this.titular = titular;
			this.saldo = 0;
	}

	public int getNumero ( ) {
			return numero;
	}

	public String getTitular ( ){
			return titular;
	}

	public double getSaldo ( ) {
			return saldo;
	}

	@PrologoMetodo (
			autor = "Carlos Fontela",
			fechaUltimaModificacion = "22/8/2007",
			version = 2 )
	public void depositar (double monto) {
		saldo += monto;
	}

	@PrologoMetodo (
			autor = "Carlos Fontela",
			fechaUltimaModificacion = "6/5/2009",
			version = 4 )
	public boolean extraer (double monto) {
		if (monto > saldo)
			throw new IllegalArgumentException ( );
		saldo -= monto;
		return true;
	}
}
