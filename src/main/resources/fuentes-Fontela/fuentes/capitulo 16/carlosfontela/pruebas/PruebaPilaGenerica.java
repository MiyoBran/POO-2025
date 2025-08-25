package carlosfontela.pruebas;

import junit.framework.TestCase;
import carlosfontela.colecciones.*;
import java.util.Date;

public class PruebaPilaGenerica extends TestCase {

	private Pila <String> pStrings = new PilaGenerica<String>( );
	private Pila <Date> pDates  = new PilaGenerica<Date>( );
	private String s1 = "Hola";
	private String s2 = "Buen día";
	private Date d1 = new Date( );
	private Date d2 = new Date (93,0,1);
	
	protected void setUp( ) throws Exception {
	}

	public void testConstructorVacio( ) {
		assertEquals (pStrings.vacia( ),true);
		assertEquals (pDates.vacia( ),true);
		assertEquals (pStrings.cardinalidad( ),0);
		assertEquals (pDates.cardinalidad( ),0);
	}
	
	public void testExcepcion1( ) {
		try {
			pStrings.eliminar( );
			fail("Debería haber lanzado excepciones: la pila está vacía");
		}
		catch (PilaVaciaException e) {}
	}
	
	public void testExcepcion2( ) {
		try {
			String s = pStrings.extraer( );
			fail("Debería haber lanzado excepciones: la pila está vacía");
		}
		catch (PilaVaciaException e) {}
	}
	
	public void testExcepcion3( ) {
		try {
			String s = pStrings.tope( );
			fail("Debería haber lanzado excepciones: la pila está vacía");
		}
		catch (PilaVaciaException e) {}
	}
	
	public void testExcepcion4( ) {
		try {
			pDates.eliminar( );
			fail("Debería haber lanzado excepciones: la pila está vacía");
		}
		catch (PilaVaciaException e) {}
	}
	
	public void testExcepcion5( ) {
		try {
			Date d = pDates.extraer( );
			fail("Debería haber lanzado excepciones: la pila está vacía");
		}
		catch (PilaVaciaException e) {}
	}
	
	public void testExcepcion6( ) {
		try {
			Date d = pDates.tope( );
			fail("Debería haber lanzado excepciones: la pila está vacía");
		}
		catch (PilaVaciaException e) {}
	}
	
	public void testAgregarTope( ) {
		try {
			pStrings.agregar(s1);
			pStrings.agregar(s2);
			pDates.agregar(d1);
			pDates.agregar(d2);
			assertEquals(pStrings.cardinalidad( ),2);
			assertEquals(pDates.cardinalidad( ),2);
			assertEquals(pStrings.tope( ),s2);
			assertEquals(pDates.tope( ),d2);
		} catch (PilaVaciaException e) {}
	}
	
	public void testEliminarExtraer( ) {
		try {
			pStrings.eliminar( );
			String s = pStrings.extraer( );
			pDates.eliminar( );
			Date d = pDates.extraer( );
			assertEquals (s, s1);
			assertEquals (d, d1);
			assertEquals (pStrings.vacia( ),true);
			assertEquals (pDates.vacia( ),true);
			assertEquals (pStrings.cardinalidad( ),0);
			assertEquals (pDates.cardinalidad( ),0);
		} catch (PilaVaciaException e) {}
	}
	
	public void testVaciar( ) {
		pStrings.agregar(s1);
		pDates.agregar(d1);
		pStrings.vaciar( );
		pDates.vaciar( );
		assertEquals (pStrings.vacia( ),true);
		assertEquals (pDates.vacia( ),true);
		assertEquals (pStrings.cardinalidad( ),0);
		assertEquals (pDates.cardinalidad( ),0);
	}
}
