// CajaAhorro.java
package carlosfontela.cuentas;

public class CajaAhorro extends CuentaBancaria {

		private double interesesGanados;

		public CajaAhorro(int numero, String titular) {
			super(numero, titular);
			this.interesesGanados = 0;
		}

		public double getInteresesGanados( ) {
			return interesesGanados;
		}

		public void setInteresesGanados(double interesesGanados) {
			this.interesesGanados = interesesGanados;
		}

		public void pagarIntereses( ) {
			setSaldo (getSaldo( ) + interesesGanados);
			interesesGanados = 0;
		}
}
