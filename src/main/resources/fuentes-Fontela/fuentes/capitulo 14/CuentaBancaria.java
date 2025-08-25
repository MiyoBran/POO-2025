public class CuentaBancaria {

		// atributos:
		private int numero;
		private String titular;
		private double saldo;

		// propiedad (sólo lectura):
		public double getSaldo( ) {
			return saldo;
		}

		// métodos:

		public void depositar (double monto) {
			saldo += monto;
		}

		public void extraer (double monto) throws SaldoInsuficienteException {
			if (monto > saldo)
				throw new SaldoInsuficienteException ( );
			else {
				saldo -= monto;
			}
		}

		// constructor:
		public CuentaBancaria (int n, String t) {
			numero = n;
			titular = t;
			saldo = 0;
		}
}
