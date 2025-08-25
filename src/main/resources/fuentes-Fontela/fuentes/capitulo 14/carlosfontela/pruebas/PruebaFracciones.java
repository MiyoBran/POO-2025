// PruebaFracciones.java
package carlosfontela.pruebas;

import carlosfontela.algebra.*;

public class PruebaFracciones {

	public static void main (String [ ] p) {

		// chequeo de construcción inválida
		try {
			Fraccion f1 = new Fraccion (5, 0);
			System.out.println ("La fracción 5/0 pudo ser construida");
		}
		catch (IllegalArgumentException e1) {
			System.out.println ("La fracción 5/0 no puede ser construida");
		}

		// chequeo de construcción válida
		try {
			Fraccion f2 = new Fraccion (2, 3);
			System.out.println ("La fracción 2/3 pudo ser construida");
		}
		catch (IllegalArgumentException e2) {
			System.out.println ("La fracción 2/3 no puede ser construida");
		}

		// chequeo de construcción válida con numerador nulo
		try {
			Fraccion f3 = new Fraccion (0, 3);
			System.out.println ("La fracción 0/3 pudo ser construida");
		}
		catch (IllegalArgumentException e3) {
			System.out.println ("La fracción 0/3 no puede ser construida");
		}

		// chequeo de división válida
		try {
			Fraccion f2 = new Fraccion (2, 3);
			Fraccion f4 = f2.dividir(f2);
			System.out.println ("Se pudo hacer la división y el resultado es: "+
 						Double.toString (f4.valorReal( )));
		}
		catch (ArithmeticException e4) {
			System.out.println ("No se pudo hacer la división");
		}

		// chequeo de división inválida
		try {
			Fraccion f2 = new Fraccion (2, 3);
			Fraccion f3 = new Fraccion (0, 3);
			Fraccion f5 = f2.dividir(f3);
			System.out.println ("Se pudo hacer la división y el resultado es: "+
 						Double.toString (f5.valorReal( )));
		}
		catch (ArithmeticException e5) {
			System.out.println ("No se pudo hacer la división");
		}
	}
}
