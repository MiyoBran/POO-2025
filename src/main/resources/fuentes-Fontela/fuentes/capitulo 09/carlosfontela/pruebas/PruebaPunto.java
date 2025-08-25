package carlosfontela.pruebas;

import carlosfontela.geometria.Punto;

public class PruebaPunto {

	public static void main (String [ ] p) {
		Punto p1 = new Punto (0,0);
		Punto p2 = new Punto (1,0);
		Punto p3 = new Punto (0,1);
		Punto p4 = new Punto (1,1);
		// pruebas del método toString:
		System.out.println (p1.toString( ));		// 0;0
		System.out.println (p2.toString( ));		// 1;0
		// pruebas de lectura de propiedades:
		System.out.println (p1.getX( ));			// 0
		System.out.println (p1.getY( ));			// 0
		System.out.println (p4.getX( ));			// 1
		System.out.println (p4.getY( ));			// 1
		// pruebas de distancia:
		System.out.println (p1.distancia(p2));		// 1
		System.out.println (p1.distancia(p4));		// 1.4142
		System.out.println (p4.distancia(p2));		// 1
		// pruebas de trasladar y cambio de propiedades:
		p4.trasladar (1,1);
		p1.trasladar (-1,0);
		System.out.println (p4.toString( ));		// 2;2
		System.out.println (p1.toString( ));		// -1;0
		p2.setX (2);
		p3.setY (2);
		System.out.println (p2.toString( ));		// 2;0
		System.out.println (p3.toString( ));		// 0;2
	}
}
