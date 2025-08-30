package carlosfontela.persistencia;

import junit.framework.TestCase;
import carlosfontela.algebra.*;
import carlosfontela.persistencia.PersistenciaFracciones;

public class PruebaPersistenciaFracciones extends TestCase {

	private String archivo = "PersistenciaFracciones.dat";
	private Fraccion f;

	public void setUp( ) {
		f = new Fraccion (2,3);
	}
	
	public void testPersistencia( )
	{
		Fraccion f1 = null;
		try {
			PersistenciaFracciones.guardarFraccion (archivo, f);
			f1 = PersistenciaFracciones.recuperarFraccion (archivo);
		}
		catch (Exception e) { /* este es un programa de prueba */ }
		assertTrue (f.compareTo(f1) == 0);
		assertFalse (f == f1);
	}
	
}
