package carlosfontela.pruebas;

import junit.framework.*;

public class PruebaPalindromo extends TestCase {

	private String s1;
	private String s2;
	private String s3;

	public void setUp( ){
		s1 = "neuquen";
		s2 = "oso";
		s3 = "ana";
	}

	public void tearDown( ){
		s1 = null;
		s2 = null;
		s3 = null;
	}

	public void testPositivo ( ) {
		assertTrue(AuxiliaresCadenas.palindromo(s1));
		assertTrue(AuxiliaresCadenas.palindromo(s2));
		assertTrue(AuxiliaresCadenas.palindromo(s3));
	}

	public void testNegativo ( ) {
		String s1 = "Caracas";
		assertFalse (AuxiliaresCadenas.palindromo(s1));
		String s2 = "osa";
		assertFalse (AuxiliaresCadenas.palindromo(s2));
		String s3 = "Ana";
		assertFalse (AuxiliaresCadenas.palindromo(s3));
	}
	
	public void testExcepcion ( ) {
		String s1 = "";
		String s2 = null;
		try {
				boolean b1 = AuxiliaresCadenas.palindromo(s1);
				boolean b2 = AuxiliaresCadenas.palindromo(s2);
			// forzamos la falla si no lanzó una excepción:
				fail ("Debería lanzar la excepción IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// la prueba tiene éxito si entramos acá
		}
	}
}
