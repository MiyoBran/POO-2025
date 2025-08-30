// PruebaFracciones.java
package carlosfontela.pruebas;

import carlosfontela.algebra.*;

public class PruebaFracciones {

	public static void main (String [ ] p) {

		// chequeo de construcci�n inv�lida
		try {
			Fraccion f1 = new Fraccion (5, 0);
			System.out.println ("La fracci�n 5/0 pudo ser construida");
		}
		catch (IllegalArgumentException e1) {
			System.out.println ("La fracci�n 5/0 no puede ser construida");
		}

		// chequeo de construcci�n v�lida
		try {
			Fraccion f2 = new Fraccion (2, 3);
			System.out.println ("La fracci�n 2/3 pudo ser construida");
		}
		catch (IllegalArgumentException e2) {
			System.out.println ("La fracci�n 2/3 no puede ser construida");
		}

		// chequeo de construcci�n v�lida con numerador nulo
		try {
			Fraccion f3 = new Fraccion (0, 3);
			System.out.println ("La fracci�n 0/3 pudo ser construida");
		}
		catch (IllegalArgumentException e3) {
			System.out.println ("La fracci�n 0/3 no puede ser construida");
		}

		// chequeo de divisi�n v�lida
		try {
			Fraccion f2 = new Fraccion (2, 3);
			Fraccion f4 = f2.dividir(f2);
			System.out.println ("Se pudo hacer la divisi�n y el resultado es: "+
 						Double.toString (f4.valorReal( )));
		}
		catch (ArithmeticException e4) {
			System.out.println ("No se pudo hacer la divisi�n");
		}

		// chequeo de divisi�n inv�lida
		try {
			Fraccion f2 = new Fraccion (2, 3);
			Fraccion f3 = new Fraccion (0, 3);
			Fraccion f5 = f2.dividir(f3);
			System.out.println ("Se pudo hacer la divisi�n y el resultado es: "+
 						Double.toString (f5.valorReal( )));
		}
		catch (ArithmeticException e5) {
			System.out.println ("No se pudo hacer la divisi�n");
		}
	}
}
