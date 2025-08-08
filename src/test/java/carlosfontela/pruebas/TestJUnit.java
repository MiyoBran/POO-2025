package carlosfontela.pruebas;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestJUnit {

	@BeforeClass // v5: @BeforeAll
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Inicia prueba general");
	}

	@AfterClass // v5: @AfterAll
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Finaliza prueba general");
	}

	@Before // v5: @BeforeEach
	public void setUp() throws Exception {
		System.out.println("Inicia prueba");
	}

	@After // v5: @AfterEach
	public void tearDown() throws Exception {
		System.out.println("Finaliza prueba");
	}

	@Test // v5: @Test
	public void test1() {
		System.out.println("Prueba 1");		
	}
			
	@Test // v5: @Test
	public void test2() {
		System.out.println("Prueba 2");
		fail("Not yet implemented");
	}
	
	
}
