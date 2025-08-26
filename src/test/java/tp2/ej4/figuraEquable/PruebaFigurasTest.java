package tp2.ej4.figuraEquable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para las clases de figuras geométricas.
 */
public class PruebaFigurasTest {

  private Elipse elipseGirada, elipseCentrada, circulo;
  private Poligono triangulo, cuadrado, rectangulo;
  private FiguraCompuesta compuesta;

  @BeforeEach
  void setUp() {
    // elipse con radios 2 y 1, girada 90° y con centro en 3; 3
    elipseGirada = new Elipse(2, 1, new Punto(3, 3), Math.PI / 2);
    // elipse con radios 3 y 2, sin girar y con centro en 0; 0
    elipseCentrada = new Elipse(3, 2);
    // círculo con centro en 0;0:
    circulo = new Elipse(2, 2);
    // triángulo rectángulo:
    Punto[] t = {new Punto(0, 0), new Punto(0, 3), new Punto(4, 0)};
    triangulo = new Poligono(t);
    // cuadrado:
    Punto[] c = {new Punto(0, 0), new Punto(0, 1), new Punto(1, 1), new Punto(1, 0)};
    cuadrado = new Poligono(c);
    // rectángulo:
    Punto[] r = {new Punto(0, 0), new Punto(0, 3), new Punto(5, 3), new Punto(5, 0)};
    rectangulo = new Poligono(r);
    // figura compuesta:
    Figura[] f = {triangulo, rectangulo};
    compuesta = new FiguraCompuesta(f);
  }

  @Test
  void testArea() {
    assertEquals(Math.PI * 2 * 1, elipseGirada.area(), 1E-4);
    assertEquals(Math.PI * 3 * 2, elipseCentrada.area(), 1E-4);
    assertEquals(Math.PI * 2 * 2, circulo.area(), 1E-4);
    assertEquals((double) (3 * 4) / 2, triangulo.area(), 1E-4);
    assertEquals(1, cuadrado.area(), 1E-4);
    assertEquals(3 * 5, rectangulo.area(), 1E-4);
    assertEquals(triangulo.area() + rectangulo.area(), compuesta.area(), 1E-4);
  }

  @Test
  void testPerimetro() {
    assertEquals(Math.PI * 4, circulo.perimetro(), 1E-4);
    assertEquals(3 + 4 + 5, triangulo.perimetro(), 1E-4);
    assertEquals(4, cuadrado.perimetro(), 1E-4);
    assertEquals(3 * 2 + 5 * 2, rectangulo.perimetro(), 1E-4);
    assertEquals(triangulo.perimetro() + rectangulo.perimetro(), compuesta.perimetro(), 1E-4);
  }

  @Test
  void testTipo() {
    assertEquals("elipse", elipseGirada.tipo());
    assertEquals("elipse", elipseCentrada.tipo());
    assertEquals("circulo", circulo.tipo());
    assertEquals("triangulo", triangulo.tipo());
    assertEquals("cuadrado", cuadrado.tipo());
    assertEquals("cuadrilatero", rectangulo.tipo());
    assertEquals("figura compuesta", compuesta.tipo());
  }

  @Test
  void testTrasladar() {
    // probar traslación del centro del círculo:
    circulo.trasladar(2, 2);
    assertEquals(new Punto(2, 2).getX(), circulo.getCentro().getX(), 1E-4);
    assertEquals(new Punto(2, 2).getY(), circulo.getCentro().getY(), 1E-4);
    // probar constancia del área después de la traslación del rectángulo:
    double a = rectangulo.area();
    rectangulo.trasladar(3, 7);
    assertEquals(a, rectangulo.area(), 1E-4);
  }

  @Test
  void testOtros() {
    assertFalse(triangulo.regular());
    assertTrue(cuadrado.regular());
    assertFalse(triangulo.regular());
  }
}

