package carlosfontela.pruebas;

import junit.framework.*;
import carlosfontela.geometria.*;


public class PruebaFiguras extends TestCase {
	
	private Elipse elipseGirada, elipseCentrada, circulo;
	private Poligono triangulo, cuadrado, rectangulo;
	private FiguraCompuesta compuesta;

	protected void setUp ( ) {
		// elipse con radios 2 y 1, girada 90º y con centro en 3;3
		elipseGirada = new Elipse (2, 1, new Punto (3, 3), Math.PI/2);
		// elipse con radios 3 y 2, sin girar y con centro en 0;0
		elipseCentrada = new Elipse (3, 2);
		// círculo con centro en 0;0:
		circulo = new Elipse (2, 2);
		// triángulo rectángulo:
		Punto[ ] t = { new Punto (0, 0), new Punto (0, 3), new Punto (4, 0) }; 
		triangulo = new Poligono(t);
		// cuadrado:
		Punto[ ] c = { new Punto (0, 0), new Punto (0, 1),
						new Punto (1, 1), new Punto (1, 0) }; 
		cuadrado = new Poligono(c);
		// rectángulo:
		Punto[ ] r = { new Punto (0, 0), new Punto (0, 3),
						new Punto (5, 3), new Punto (5, 0) }; 
		rectangulo = new Poligono(r);
		// figura compuesta:
		Figura[ ] f = { triangulo, rectangulo };
		compuesta = new FiguraCompuesta(f);
	}

	public void testArea( ) {
		assertEquals (Math.PI*2*1, elipseGirada.getArea(), 1E-4);
		assertEquals (Math.PI*3*2, elipseCentrada.getArea(), 1E-4);
		assertEquals (Math.PI*2*2, circulo.getArea(), 1E-4);
		assertEquals (3*4/2, triangulo.getArea(), 1E-4);
		assertEquals (1, cuadrado.getArea(), 1E-4);
		assertEquals (3*5, rectangulo.getArea(), 1E-4);
		assertEquals (triangulo.getArea() + rectangulo.getArea(), compuesta.getArea(), 1E-4);
	}

	public void testPerimetro( ) {
		assertEquals (Math.PI*4, circulo.getPerimetro(), 1E-4);
		assertEquals (3+4+5, triangulo.getPerimetro(), 1E-4);
		assertEquals (4, cuadrado.getPerimetro(), 1E-4);
		assertEquals (3*2+5*2, rectangulo.getPerimetro(), 1E-4);
		assertEquals (triangulo.getPerimetro() + rectangulo.getPerimetro(),
								compuesta.getPerimetro(), 1E-4);
	}

	public void testTipo( ) {
		assertEquals ("elipse", elipseGirada.getTipo());
		assertEquals ("elipse", elipseCentrada.getTipo());
		assertEquals ("círculo", circulo.getTipo());
		assertEquals ("triángulo", triangulo.getTipo());
		assertEquals ("cuadrado", cuadrado.getTipo());
		assertEquals ("cuadrilátero", rectangulo.getTipo());
		assertEquals ("figura compuesta", compuesta.getTipo());
	}

	public void testTrasladar( ) {
		// probar traslación del centro del círculo:
		circulo.trasladar(2, 2);
		assertEquals (new Punto (2, 2).getX(), circulo.getCentro().getX(), 1E-4);
		assertEquals (new Punto (2, 2).getY(), circulo.getCentro().getY(), 1E-4);
		// probar constancia del área después de la traslación del rectángulo:
		double a = rectangulo.getArea();
		rectangulo.trasladar (3, 7);
		assertEquals (a, rectangulo.getArea(), 1E-4);
	}

	public void testOtros( ) {
		assertEquals (false, triangulo.isRegular());
		assertEquals (true, cuadrado.isRegular());
		assertEquals (false, triangulo.isRegular());
		assertEquals (3, triangulo.getNumeroLados());
		assertEquals (4, cuadrado.getNumeroLados());
		assertEquals (4, rectangulo.getNumeroLados());
	}
}
