public class PruebaCuentaBancaria {

	public static void main (String [ ] p) {
		// número, titular:
		CuentaBancaria cuenta = new CuentaBancaria (24517,"Fontela");
		cuenta.depositar (2000);	// depósito de 2000 pesos
		boolean exito = cuenta.extraer (700);
		if (!exito) System.out.println ("Fondos insuficientes");
		System.out.println (cuenta.getSaldo( ));
	}

}
