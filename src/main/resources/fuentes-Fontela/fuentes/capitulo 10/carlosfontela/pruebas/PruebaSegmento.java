package carlosfontela.pruebas;

import carlosfontela.geometria.*;

public class PruebaSegmento {

	public static void main(String [ ] p) {

		Punto p1 = new Punto(0,0);
		Punto p2 = new Punto(1,0);
		Punto p3 = new Punto(0,1);
		Punto p4 = new Punto(1,1);
		Segmento s1 = new Segmento(p1,p2);
		Segmento s2 = new Segmento(p3,p4);

		// pruebas de lectura de estado:
		if (s1.extremo(1) == p1)
			System.out.println("OK");
		else System.out.println("ERROR");
		if (s2.extremo(2) == p4)
			System.out.println("OK");
		else System.out.println("ERROR");
		if (s1.extremo(1) == p1)
			System.out.println("OK");
		else System.out.println("ERROR");
		if (s1.getLongitud() == p1.distancia(p2))
			System.out.println("OK");
		else System.out.println("ERROR");
		if (s2.getLongitud() == p3.distancia(p4))
			System.out.println("OK");
		else System.out.println("ERROR");
		if (s1.getAnguloX() == 0)
			System.out.println("OK");
		else System.out.println("ERROR");

		// pruebas de cambio de extremo:
		s1.cambiarExtremo(2,p4);
		if (s1.extremo(2) == p4)
			System.out.println("OK");
		else System.out.println("ERROR");
		if (s1.getLongitud() == p1.distancia(p4))
			System.out.println("OK");
		else System.out.println("ERROR");
		if (s1.getAnguloX() == Math.PI/4)
			System.out.println("OK");
		else System.out.println("ERROR");

	}
}
