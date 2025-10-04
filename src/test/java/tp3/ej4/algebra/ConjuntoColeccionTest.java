package tp3.ej4.algebra;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConjuntoColeccionTest {

  private Conjunto a = new ConjuntoArreglo(5);
  private Conjunto b = new ConjuntoColeccion(10);
  private Conjunto c;

  // De prueba Conjuntos
  private Conjunto aA = new ConjuntoArreglo(30);
  private Conjunto eA = new ConjuntoBits(30);
  private Conjunto aB = new ConjuntoColeccion(30);
  private Conjunto eB = new ConjuntoBits(30);
  private Conjunto aC = new ConjuntoColeccion(30);
  private Conjunto eC = new ConjuntoBits(30);

  @BeforeEach
  void setUp() {
    // De PruebaConjuntos2
    a.agregarElemento(0);
    a.agregarElemento(2);
    a.agregarElemento(4);
    b.agregarElemento(4);
    b.agregarElemento(8);
    // De PruebaConjuntos
    aA.agregarElemento(8);
    eA.agregarElemento(8);
    aA.agregarElemento(9);
    eA.agregarElemento(9);
    aB.agregarElemento(3);
    eB.agregarElemento(3);
    aB.agregarElemento(9);
    eB.agregarElemento(9);
  }

  // Extraido de PruebaConjuntos
  @Test
  void union() {
    aC = aA.union(eB);
    eC = eA.union(aB);
    assertEquals (3, aC.cardinalidad( ));
    assertEquals (3, eC.cardinalidad( ));
    assertTrue (aC.pertenece(3));
    assertTrue (aC.pertenece(8));
    assertTrue (aC.pertenece(9));
    assertTrue (eC.pertenece(3));
    assertTrue (eC.pertenece(8));
    assertTrue (eC.pertenece(9));
    // la uni�n es conmutativa:
    aC = eB.union(aA);
    eC = aB.union(eA);
    assertEquals (3, aC.cardinalidad( ));
    assertEquals (3, eC.cardinalidad( ));
    assertTrue (aC.pertenece(3));
    assertTrue (aC.pertenece(8));
    assertTrue (aC.pertenece(9));
    assertTrue (eC.pertenece(3));
    assertTrue (eC.pertenece(8));
    assertTrue (eC.pertenece(9));
  }

  // Extraido de PruebaConjuntos
  @Test
  void interseccion() {
    aC = eA.interseccion(eB);
    eC = aA.interseccion(aB);
    assertEquals (1, aC.cardinalidad( ));
    assertEquals (1, eC.cardinalidad( ));
    assertFalse (aC.pertenece(3));
    assertFalse (aC.pertenece(8));
    assertTrue (aC.pertenece(9));
    assertFalse (eC.pertenece(3));
    assertFalse (eC.pertenece(8));
    assertTrue (eC.pertenece(9));
    // la intersecci�n es conmutativa:
    aC = eB.interseccion(eA);
    eC = aB.interseccion(aA);
    assertEquals (1, aC.cardinalidad( ));
    assertEquals (1, eC.cardinalidad( ));
    assertFalse (aC.pertenece(3));
    assertFalse (aC.pertenece(8));
    assertTrue (aC.pertenece(9));
    assertFalse (eC.pertenece(3));
    assertFalse (eC.pertenece(8));
    assertTrue (eC.pertenece(9));
  }

  // Extraido de PruebaConjuntos
  @Test
  void diferencia() {
    aC = eA.diferencia(aB);
    eC = aA.diferencia(eB);
    assertEquals (1, aC.cardinalidad( ));
    assertEquals (1, eC.cardinalidad( ));
    assertFalse (aC.pertenece(3));
    assertTrue (aC.pertenece(8));
    assertFalse (aC.pertenece(9));
    assertFalse (eC.pertenece(3));
    assertTrue (eC.pertenece(8));
    assertFalse (eC.pertenece(9));
    // la diferencia no es conmutativa:
    aC = aB.diferencia(eA);
    eC = eB.diferencia(aA);
    assertEquals (1, aC.cardinalidad( ));
    assertEquals (1, eC.cardinalidad( ));
    assertTrue (aC.pertenece(3));
    assertFalse (aC.pertenece(8));
    assertFalse (aC.pertenece(9));
    assertTrue (eC.pertenece(3));
    assertFalse (eC.pertenece(8));
    assertFalse (eC.pertenece(9));
  }

  // Extraido de PruebaConjuntos
  @Test
  void incluido() {
    assertFalse (eA.incluido(eB));
    assertFalse (eB.incluido(eA));
    assertFalse (aA.incluido(aB));
    assertFalse (aB.incluido(aA));
    aA.agregarElemento(3);
    eA.agregarElemento(3);
    assertFalse (eA.incluido(eB));
    assertTrue (eB.incluido(eA));
    assertFalse (aA.incluido(aB));
    assertTrue (aB.incluido(aA));
  }

  // Extraido de PruebaConjuntos
  @Test
  void igual() {
    // ambas implementaciones deben dar iguales resultados:
    assertTrue (eA.igual(aA));
    assertTrue (eB.igual(aB));
  }

  // Extraido de PruebaConjuntos
  @Test
  void pertenece() {
    assertTrue (aA.pertenece(8));
    assertTrue (eA.pertenece(8));
    assertTrue (aA.pertenece(9));
    assertTrue (eA.pertenece(9));
    assertEquals (2, aA.cardinalidad( ));
    assertEquals (2, eA.cardinalidad( ));
    assertTrue (aB.pertenece(3));
    assertTrue (eB.pertenece(3));
    assertFalse (aB.pertenece(8));
    assertFalse (eB.pertenece(8));
    assertTrue (aB.pertenece(9));
    assertTrue (eB.pertenece(9));
    assertEquals (2, aB.cardinalidad( ));
    assertEquals (2, eB.cardinalidad( ));
  }

  // Extraido de PruebaConjuntos
  @Test
  void vacio() {
    assertTrue (aC.vacio( ));
    assertTrue (eC.vacio( ));
    assertEquals (0, aC.cardinalidad( ));
    assertEquals (0, eC.cardinalidad( ));
  }

  // Extraido de PruebaConjuntos
  @Test
  void vaciar() {
    aC.agregarElemento(4);
    eC.agregarElemento(12);
    aC.vaciar( );
    eC.vaciar( );
    assertTrue (aC.vacio( ));
    assertTrue (eC.vacio( ));
  }

  // Extraido de PruebaConjuntos
  @Test
  void sacarElemento() {
    // sacamos un elemento
    aA.sacarElemento(3);
    assertEquals (2, aA.cardinalidad( ));
    assertFalse (aA.pertenece(3));
    // sacamos un elemento que no est�
    aA.sacarElemento(125);
    assertEquals (2, aA.cardinalidad( ));
    assertFalse (aA.pertenece(25));
    // sacamos un elemento
    aA.sacarElemento(8);
    assertEquals (1, aA.cardinalidad( ));
    assertFalse (aA.pertenece(8));
    // sacamos un elemento que no est� pero estaba
    aA.sacarElemento(8);
    assertEquals (1, aA.cardinalidad( ));
    assertFalse (aA.pertenece(8));
    // sacamos un elemento
    aA.sacarElemento(9);
    assertEquals (0, aA.cardinalidad( ));
    assertFalse (aA.pertenece(9));
    assertTrue (aA.vacio( ));
  }


  // De PruebaDiferenciaSimetrica
  @Test
  void diferenciaSimetrica_ab() {
    c = a.diferenciaSimetrica(b);
    assertEquals(3, c.cardinalidad());
    assertTrue(c.pertenece(0));
    assertTrue(c.pertenece(2));
    assertTrue(c.pertenece(8));
  }

  // De PruebaDiferenciaSimetrica
  @Test
  void testDiferenciaSimetrica_ba() {
    c = a.diferenciaSimetrica(b);
    assertEquals(3, c.cardinalidad());
    assertTrue(c.pertenece(0));
    assertTrue(c.pertenece(2));
    assertTrue(c.pertenece(8));
  }

  // Extraido de PruebaConjuntos2
  @Test
  void testDiferencia_ab() {
    c = a.diferencia(b);
    assertEquals (2, c.cardinalidad( ));
    assertTrue (c.pertenece(0));
    assertTrue (c.pertenece(2));
  }

  // Extraido de PruebaConjuntos2
  @Test
  void testDiferencia_ba() {
    c = b.diferencia(a);
    assertEquals (1, c.cardinalidad( ));
    assertTrue (c.pertenece(8));
  }

  // Extraido de PruebaConjuntos2
  @Test
  void testIguales() {
    b.agregarElemento(0);
    b.agregarElemento(2);
    b.sacarElemento(8);
    assertTrue (a.igual(b));
    assertTrue (b.igual(a));
  }

  // Extraido de PruebaConjuntos2
  @Test
  void testNoIguales() {
    assertFalse (a.igual(b));
    assertFalse (b.igual(a));
  }


  @Test
  void getBase() {
    assertEquals(5, a.getBase());
    assertEquals(10, b.getBase());
    assertEquals(30, aA.getBase());
    assertEquals(30, eA.getBase());
    assertEquals(30, aB.getBase());
    assertEquals(30, eB.getBase());
    assertEquals(30, aC.getBase());
    assertEquals(30, eC.getBase());
  }

  @Test
  void agregarElemento() {
    assertEquals(3, a.cardinalidad());
    a.agregarElemento(1);
    assertEquals(4, a.cardinalidad());
  }

  @Test
  void testAgregarElemento_FueraDeRango_NoModificaConjunto() {
    ConjuntoColeccion conjunto = new ConjuntoColeccion(5);
    conjunto.agregarElemento(-1);
    conjunto.agregarElemento(10);
    assertEquals(0, conjunto.cardinalidad());
    assertFalse(conjunto.pertenece(-1));
    assertFalse(conjunto.pertenece(10));
  }

}
