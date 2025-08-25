import carlosfontela.utilidades.*;

public class NumerosPrimos {

	static final int hasta = 2000;
	
	public static void main (String [ ] p) {

		// creo un conjunto con todos los números candidatos:
		int tamanioConjunto = hasta;
		Conjunto candidatos = new Conjunto (tamanioConjunto);
		for (int x = 2; x <= hasta; x++)
			candidatos.agregarElemento(x);

		// empiezo con todos los candidatos como primos:
		Conjunto primos = candidatos;

		// aplico la criba:
		for (int x = 2; x <= hasta; x++)
			if (primos.pertenece(x)) {	// el número x es primo
				// elimino sus múltiplos:
				for (int multiplo = x+x; multiplo <= hasta; multiplo += x)
					primos.sacarElemento(multiplo);
			}
		
		// imprimo resultados:
		System.out.print("Cantidad de primos: ");
		System.out.println(primos.getCardinalidad( ));
		System.out.println("Números primos:");
		for (int x = 2; x <= hasta; x++)
			if (primos.pertenece(x)) {
				System.out.print(x);
				System.out.print(" ");
			}
	}

}
