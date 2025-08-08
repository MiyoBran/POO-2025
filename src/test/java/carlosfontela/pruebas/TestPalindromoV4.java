package carlosfontela.pruebas;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import carlosfontela.auxiliares.AuxiliaresCadenas;

public class TestPalindromoV4 {

	private String s1;
	private String s2;
	private String s3;
	
	@Before
	public void setUp() throws Exception {
		s1 = "neuquen";
		s2 = "oso";
		s3 = "ana";		
	}

	@After
	public void tearDown() throws Exception {
		s1 = null;
		s2 = null;
		s3 = null;
	}

	@Test
	public void positivo ( ) {
		assertTrue(AuxiliaresCadenas.palindromo(s1));
		assertTrue(AuxiliaresCadenas.palindromo(s2));
		assertTrue(AuxiliaresCadenas.palindromo(s3));
	}
	
	@Test	
	public void testNegativo ( ) {
		String s1 = "Caracas";
		assertFalse (AuxiliaresCadenas.palindromo(s1));
		String s2 = "osa";
		assertFalse (AuxiliaresCadenas.palindromo(s2));
		String s3 = "Ana";
		assertFalse (AuxiliaresCadenas.palindromo(s3));
	}
	
}
