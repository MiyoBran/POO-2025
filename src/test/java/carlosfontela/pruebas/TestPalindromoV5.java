package carlosfontela.pruebas;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import carlosfontela.auxiliares.AuxiliaresCadenas;


class TestPalindromoV5 {
	private String s1;
	private String s2;
	private String s3;
	
	@BeforeEach
	void setUp() throws Exception {
		s1 = "neuquen";
		s2 = "oso";
		s3 = "ana";		
	}

	@AfterEach
	void tearDown() throws Exception {
		s1 = null;
		s2 = null;
		s3 = null;
	}
	
	
	@Test
	void positivo ( ) {
		assertTrue(AuxiliaresCadenas.palindromo(s1));
		assertTrue(AuxiliaresCadenas.palindromo(s2));
		assertTrue(AuxiliaresCadenas.palindromo(s3));
	}
	
	@Test	
	void testNegativo ( ) {
		String s1 = "Caracas";
		assertFalse (AuxiliaresCadenas.palindromo(s1));
		String s2 = "osa";
		assertFalse (AuxiliaresCadenas.palindromo(s2));
		String s3 = "Ana";
		assertFalse (AuxiliaresCadenas.palindromo(s3));
	}
	
	/*@Test
	void test() {
		fail("Not yet implemented");
	}*/

}
