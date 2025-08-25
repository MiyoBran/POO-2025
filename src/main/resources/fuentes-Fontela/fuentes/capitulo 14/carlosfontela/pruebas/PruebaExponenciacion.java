package carlosfontela.pruebas;

import carlosfontela.algebra.Exponenciacion;

public class PruebaExponenciacion {

	public static void main (String [ ] p) {

		// 2^3 debería dar 8 sin problema
		try {
			double r = Exponenciacion.potencia (2.0, 3.0);
			System.out.println ("2^3 se pudo realizar y el resultado es: " + r);
		}
		catch (ArithmeticException e) {
			System.out.println ("2^3 no se pudo realizar. " + e.getMessage());
		}

		// 1.5^2 debería dar 2.25 sin problema
		try {
			double r = Exponenciacion.potencia (1.5, 2.0);
			System.out.println ("1.5^2 se pudo realizar y el resultado es: " + r);
		}
		catch (ArithmeticException e) {
			System.out.println ("1.5^2 no se pudo realizar. " + e.getMessage());
		}

		// 0^0 no se debería poder hacer
		try {
			double r = Exponenciacion.potencia (0.0, 0.0);
			System.out.println ("0^0 se pudo realizar y el resultado es: " + r);
		}
		catch (ArithmeticException e) {
			System.out.println ("0^0 no se pudo realizar. " + e.getMessage());
		}

		// -3.5^2.8 no se debería poder hacer porque el resultado es complejo
		try {
			double r = Exponenciacion.potencia (-3.5, 2.8);
			System.out.println ("-3.5^2.8 se pudo realizar y el resultado es: " + r);
		}
		catch (ArithmeticException e) {
			System.out.println ("-3.5^2.8 no se pudo realizar. " + e.getMessage());
		}

		// -3.5^2.8 se debería poder hacer porque el resultado es real
		try {
			double r = Exponenciacion.potencia (3.5,2.8);
			System.out.println ("3.5^2.8 se pudo realizar y el resultado es: " + r);
		}
		catch (ArithmeticException e) {
			System.out.println ("3.5^2.8 no se pudo realizar. " + e.getMessage());
		}
	}
}
