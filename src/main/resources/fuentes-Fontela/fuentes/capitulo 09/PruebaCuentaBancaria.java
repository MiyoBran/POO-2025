public class PruebaCuentaBancaria {

	public static void main (String [ ] p) {
		// n�mero, titular:
		CuentaBancaria cuenta = new CuentaBancaria (24517,"Fontela");
		cuenta.depositar (2000);	// dep�sito de 2000 pesos
		boolean exito = cuenta.extraer (700);
		if (!exito) System.out.println ("Fondos insuficientes");
		System.out.println (cuenta.getSaldo( ));
	}

}
