// CuentaBancaria.java
package poo.cuentas;

public abstract class CuentaBancaria {

		private int numero;
		private String titular;
		private double saldo;

		public CuentaBancaria (int numero, String titular) {
			this.numero = numero;
			this.titular = titular;
			this.saldo = 0;
		}

		public int getNumero( ) {
			return numero;
		}

		public String getTitular( ) {
			return titular;
		}

		public double getSaldo( ) {
			return saldo;
		}

		protected void setSaldo (double saldo) {
			this.saldo = saldo;
		}

		public void depositar (double monto) {
			saldo += monto;
		}

		abstract public void extraer (double monto) throws SaldoInsuficienteException;
}
