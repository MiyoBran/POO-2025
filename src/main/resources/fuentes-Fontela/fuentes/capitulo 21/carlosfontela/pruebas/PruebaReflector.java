// PruebaReflector.java
package carlosfontela.pruebas;

import carlosfontela.reflexion.Reflector;

public class PruebaReflector {

	public static void main (String [ ] p) {
		Reflector r = null;
		try {
			r = new Reflector ("carlosfontela.geometria.Punto");
		}
		catch (ClassNotFoundException e) {
			System.out.println("No se encontró la clase");
		}
		String xml = r.claseXML( );
		System.out.println(xml);
	}

}
